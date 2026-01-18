package sp.statsplayer.StatsPlayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp.statsplayer.StatsPlayer.model.Stats;
import sp.statsplayer.StatsPlayer.repository.StatsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsRepository statsRepository;
    //get all info
    @CrossOrigin
    @GetMapping
    public List<Stats> findAll() {
        return statsRepository.findAll();
    }
    //get by id
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Stats> findById(@PathVariable String id) {
        Optional<Stats> stats = statsRepository.findById(id);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //create
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Stats> save(@RequestBody Stats stats) {
        Stats saveStats = statsRepository.save(stats);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStats);
    }
    //delete
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        if(!statsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        statsRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
    //update
    @CrossOrigin
    @PutMapping("/uodate/{id}")
    public ResponseEntity<Stats> update(@PathVariable String id, @RequestBody Stats stats) {
        if(!statsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stats.setUuid(id);
        return ResponseEntity.ok(statsRepository.save(stats));
    }
}
