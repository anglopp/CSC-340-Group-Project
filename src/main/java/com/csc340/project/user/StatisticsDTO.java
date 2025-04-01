package user;

// DTO to help with statistics
public class StatisticsDTO {

    private long numberOfStudents;
    private long numberOfTutors;
    private long numberOfClasses;
    private long numberOfReviews;

    // Constructor
    public StatisticsDTO(long numberOfStudents, long numberOfTutors, long numberOfClasses, long numberOfReviews) {
        this.numberOfStudents = numberOfStudents;
        this.numberOfTutors = numberOfTutors;
        this.numberOfClasses = numberOfClasses;
        this.numberOfReviews = numberOfReviews;
    }

    // Getters and setters
    public long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public long getNumberOfTutors() {
        return numberOfTutors;
    }

    public void setNumberOfTutors(long numberOfTutors) {
        this.numberOfTutors = numberOfTutors;
    }

    public long getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(long numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public long getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(long numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
}
