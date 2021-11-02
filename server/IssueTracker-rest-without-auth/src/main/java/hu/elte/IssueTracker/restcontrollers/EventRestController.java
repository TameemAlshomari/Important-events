package hu.elte.IssueTracker.restcontrollers;

import hu.elte.IssueTracker.entities.Event;
import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.entities.Label;
import hu.elte.IssueTracker.entities.Message;
import hu.elte.IssueTracker.entities.User;
import hu.elte.IssueTracker.repositories.EventRepository;
import hu.elte.IssueTracker.repositories.IssueRepository;
import hu.elte.IssueTracker.repositories.LabelRepository;
import hu.elte.IssueTracker.repositories.MessageRepository;
import hu.elte.IssueTracker.repositories.UserRepository;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tameem
 */

@RestController
@RequestMapping("/api/events")
public class EventRestController {
 
    @Autowired
    private EventRepository eventRepository;
      
    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private LabelRepository labelRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Event>> getAll(Principal principal) {
        return ResponseEntity.ok(eventRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Event> get(@PathVariable Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
//    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping("/{id}/solution")
//    public ResponseEntity<Event> add(@RequestBody Event event) {
//        System.out.println("tameemtameemtameemtameemtameemtameemtameemtameemtameemtameemtameemtameem");
//        Event savedEvent = eventRepository.save(event);
//        return ResponseEntity.ok(savedEvent);
//    }
    
    @PostMapping("")
    public ResponseEntity<Event> post(@RequestBody Event event) {
  
        Event savedIssue = eventRepository.save(event);
        return ResponseEntity.ok(savedIssue);
    }
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Event> update
            (@PathVariable Integer id,
             @RequestBody Event issue) {
        Optional<Event> oIssue = eventRepository.findById(id);
        if (oIssue.isPresent()) {
            issue.setId(id);
            return ResponseEntity.ok(eventRepository.save(issue));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Issue> delete
            (@PathVariable Integer id) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            issueRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     
}
