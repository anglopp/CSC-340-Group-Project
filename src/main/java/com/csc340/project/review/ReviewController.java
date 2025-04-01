package review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutelage/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * Get all reviews from the database.
     * URL: http://localhost:8080/tutelage/reviews
     * Method: GET
     *
     * @return A list of all reviews, including the tutor and student details
     */
    @GetMapping
    public List<Review.ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Delete a review by its ID.
     * URL: http://localhost:8080/tutelage/reviews/{id}
     * Method: DELETE
     *
     * @param id The ID of the review to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}
