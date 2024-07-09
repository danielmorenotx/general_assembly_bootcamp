// ----- VARIABLES -----
const postedCommentsContainer = document.createElement("div");
postedCommentsContainer.classList.add("posted-comments");

const commentElement = document.createElement("div");
commentElement.classList.add("comment");



// -- post a comment --
function postComment(event) {
    // retrieve content in text box
    const postId = event.target.getAttribute("data-blog-post-id");
    const commentTextArea = document.querySelector(`textarea[data-blog-post-id="${postId}"]`);

    const commentText = commentTextArea.value;

    if (commentText !== "") {
        const newComment = {
            username: localStorage.getItem("username"),
            commentText: commentText
        };

        const postIndex = blogPosts.findIndex(post => post.id === parseInt(postId));

        if (postIndex !== -1) {
            blogPosts[postIndex].comments.push(newComment);
            displayBlogPosts();
        } else {
            console.error("Blog post does not exist!");
        }
    } else {
        console.error("Comment cannot be empty!")
    }
}

// Get all textarea elements on the page
const textAreas = document.querySelectorAll("textarea");

// Add event listener to each textarea
textAreas.forEach(textArea => {
    textArea.addEventListener("click", clearTextArea);
});

// Function to clear textarea and set text color to black
function clearTextArea(event) {
    const textarea = event.target;
    textarea.value = ""; // Clear the textarea content
    textarea.style.color = "black"; // Set text color to black
}