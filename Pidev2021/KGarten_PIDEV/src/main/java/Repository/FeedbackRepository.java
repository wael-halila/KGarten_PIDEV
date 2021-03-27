package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Feedback;
import org.springframework.stereotype.Repository;

@Repository

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
