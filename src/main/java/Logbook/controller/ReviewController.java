package Logbook.controller;

import Logbook.model.Review;
import Logbook.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String listReviews(Model model) {
        List<Review> reviews = reviewService.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews/list";
    }

    @GetMapping("/create")
    public String createReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/create";
    }

    @PostMapping("/create")
    public String createReview(Review review) {
        reviewService.save(review);
        return "redirect:/reviews";
    }

}
