package review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Get all reviews in the database.
     *
     * @return A list of ReviewDTO objects with the reviews and related tutor/student data
     */
    public List<Review.ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        // Convert each review to a ReviewDTO with tutor/student info
        return reviews.stream()
                .map(Review::toDTO) // Convert each Review to its DTO
                .collect(Collectors.toList());
    }

    /**
     * Delete a review by ID.
     *
     * @param reviewId The ID of the review to be deleted
     */
    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
