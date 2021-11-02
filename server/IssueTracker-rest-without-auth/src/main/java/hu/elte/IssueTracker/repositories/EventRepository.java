
package hu.elte.IssueTracker.repositories;

import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.entities.Event;
import hu.elte.IssueTracker.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
