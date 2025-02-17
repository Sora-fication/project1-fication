package com.example.java_app.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.java_app.model.Book;

@Controller
public class BookController {
    private final List<Book> books = Arrays.asList(
    new Book(1, "Ikigai", "Héctor García and Francesc Miralles", "2017", 
             "explores the Japanese concept of ikigai, which means \"a reason for being.\" " +
             "The book delves into the cultural philosophy that emphasizes finding purpose and joy in everyday life. " +
             "It combines wisdom from the people of Okinawa, known for their longevity, with practical advice on how to live a meaningful, fulfilling life. " +
             "By identifying and pursuing your ikigai, you can achieve balance, happiness, and a sense of purpose.", "/images/book1.jpg"),
             
    new Book(2, "The Travelling Cat Chronicles", "Hiro Arikawa", "2018", 
             "a heartwarming and poignant novel that follows the journey of a cat named Nana and her owner, Satoru. " +
             "The story unfolds through the eyes of Nana as they travel together across Japan, seeking a new home for the cat after Satoru faces personal struggles. " +
             "With themes of friendship, love, loss, and the bond between humans and animals, the book beautifully explores the complexities of relationships, " +
             "the meaning of home, and the importance of connection in a fast-paced world.", "/images/book2.jpg"),
             
    new Book(3, "Better Than the Movies", "Lynn Painter", "2021", 
             "a refreshing and humorous coming-of-age story about Liz Buxbaum, a high school senior with a passion for rom-coms. " +
             "As her senior year unfolds, she faces unexpected challenges with her family and friendships, while discovering new perspectives on what really matters. " +
             "With a mix of wit and insight, the book captures Liz’s journey of self-discovery and navigating life’s twists and turns, all while balancing the high school experience " +
             "and her growing understanding of herself.", "/images/book3.jpg"),
             
    new Book(4, "The Midnight Library", "Matt Haig", "2020", 
             "a thought-provoking and uplifting novel that follows the story of Nora Seed as she finds herself in a mysterious library between life and death. " +
             "Each book in the library represents a different life she could have lived, and Nora has the chance to explore these alternate realities and make different choices. " +
             "Through her journey, she discovers the power of regret, forgiveness, and the importance of embracing life’s uncertainties. " +
             "The book offers a poignant reflection on the paths we choose and the possibilities that exist in every moment.", "/images/book4.jpg"),
             
    new Book(5, "The House in the Cerulean Sea", "TJ Klune", "2020", 
             "a whimsical and enchanting tale that follows the story of Linus Baker, a caseworker at the Department in Charge of Magical Youth. " +
             "When he is assigned to a special mission at the Marsyas Island Orphanage, Linus encounters a group of extraordinary children with magical abilities and a mysterious caretaker named Arthur Parnassus. " +
             "As Linus gets to know the children and Arthur, he embarks on a journey of self-discovery, acceptance, and love. " +
             "The book celebrates the power of kindness, found family, and embracing differences in a world that often values conformity.", "/images/book5.jpg"),
             
    new Book(6, "A Slice of Life", "Margaret Lake", "2012", 
             "Grace Coulter has been hiding in the kitchen of her family restaurant since she was eight years old. " +
             "That’s when the name-calling began. Stretch, skinny-minny, boy in girl’s clothes, all because of the slender height that had her towering over even the tallest boys in the class. " +
             "Now, nearly thirty years later, Grace is head chef of the failing restaurant and still hiding in the kitchen. " +
             "Like many businesses during the current recession, Coulter’s may have to start laying off employees or even close. " +
             "But Grace has a plan to save the restaurant and the people she’s known all her life; a plan that will force her to go out into the world and face her fears.", "/images/book6.jpg"),

    new Book(7, "Pride and Prejudice", "Jane Austen", "1813", 
             "a classic novel set in the early 19th century, follows the life of Elizabeth Bennet as she navigates issues of love, marriage, and society. " +
             "The story explores the complexities of relationships, class, and family, with a particular focus on the developing relationship between Elizabeth and the proud but honorable Mr. Darcy. " +
             "Through witty dialogue and insightful commentary, the novel examines themes of personal growth, prejudice, and the social pressures that define one’s life choices.", "/images/book7.jpg"),

    new Book(8, "The Good Part", "Sophie Cousens", "2020", 
             "a delightful and introspective novel that follows the story of a young woman as she navigates the ups and downs of life, relationships, and career. " +
             "With moments of humor, growth, and realization, the book is about learning to embrace change, find joy in the present, and pursue what truly matters in life. " +
             "The protagonist's journey is filled with lighthearted moments of self-discovery, as she takes on challenges with optimism and a sense of adventure.", "/images/book8.jpg"),

    new Book(9, "The Flatshare", "Beth O'Leary", "2019", 
             "a heartwarming and delightful story about Tiffy and Leon, two people who share a flat in London, but have never met. " +
             "Due to their unconventional living situation, Tiffy and Leon communicate through notes and eventually develop a unique bond. " +
             "This charming novel is filled with humor, heart, and touching moments, as the characters navigate their personal struggles and unexpected friendship. It’s a tale about the power of connection, unconventional relationships, and finding love in unexpected ways.", "/images/book9.jpg"),
    

    new Book(10, "The Comfort Food Diaries", "Emily Nunn", "2021", 
             "a warm and feel-good memoir that blends personal stories with recipes, celebrating the comfort and healing power of food. " +
             "Through stories of family, friendship, and food, the author explores how the simple act of cooking can bring people together and provide solace during challenging times. " +
             "This book is a tribute to the joy of cooking, sharing meals, and the comfort that food can bring to our hearts and minds.", "/images/book10.jpg")
             
);


    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books"; // Or use getBooks() here if you want to show the list directly
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/books/{id}")
    public String getBookDetails(@PathVariable int id, Model model) {
        books.stream()
            .filter(book -> book.getId() == id)
            .findFirst()
            .ifPresent(book -> model.addAttribute("book", book));
        return "bookdetails";
    }
}
