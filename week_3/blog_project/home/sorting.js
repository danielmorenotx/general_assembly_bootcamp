// -- sort by date posted --
function sortByNewestToOldest() {
    blogPosts.sort((a,b) => {
        return new Date(a.timestamp) - new Date(b.timestamp);
    });
}

function sortByOldestToNewest() {
    blogPosts.sort((a,b) => {
        return new Date(b.timestamp) - new Date(a.timestamp);
    });
}

function displaySortedBlogPosts() {
    postedBlogsEl.innerHTML = "";

    console.log(displayBlogPosts())
    displayBlogPosts();
}

const sortByMenu = document.getElementById("sort-by");
sortByMenu.addEventListener("change",sortPosts)

function sortPosts() {
    const sortByValue = sortByMenu.value;
    console.log(sortByValue)

    // Check the selected value and sort blog posts accordingly
    if (sortByValue === "oldest") {
        sortByOldestToNewest();
    } else if (sortByValue === "newest") {
        sortByNewestToOldest();
    }

    console.log(displaySortedBlogPosts)
    // Display sorted blog posts
    displaySortedBlogPosts();
};

// -- filter posts --
function filterBlogPosts(searchTerm) {
    const filteredPosts = blogPosts.filter(post => {
        // Convert title and body to lowercase for case-insensitive search
        const title = post.title.toLowerCase();
        const body = post.body.toLowerCase();
        // Convert search term to lowercase as well
        const term = searchTerm.toLowerCase();
        // Check if title or body contains the search term
        return title.includes(term) || body.includes(term);
    });
    return filteredPosts;
}

function displayFilteredBlogPosts(searchTerm) {
    // Clear the blog section
    postedBlogsEl.innerHTML = "";

    // Filter the blog posts based on the search term
    const filteredPosts = filterBlogPosts(searchTerm);

    // Display the filtered blog posts
    filteredPosts.forEach(post => {
        const postContainerEl = document.createElement("article");
        const blogTitleEl = document.createElement("h2");
        blogTitleEl.setAttribute("class", "article-title");
        const blogBodyEl = document.createElement("p");

        // Add class to post container
        postContainerEl.classList.add("column-format");

        // Assign values to the elements
        blogTitleEl.textContent = post.title;
        blogBodyEl.textContent = post.body;

        // Append post elements to the container
        postContainerEl.appendChild(blogTitleEl);
        postContainerEl.appendChild(blogBodyEl);

        // Create and append comments section
        createCommentsSection(postContainerEl, post.id);

        // Append comments to the container
        post.comments.forEach(comment => {
            const commentElement = document.createElement("div");
            commentElement.classList.add("comment");
            commentElement.innerHTML = `<h5>${comment.username}</h5><p>${comment.commentText}</p>`;
            postContainerEl.appendChild(commentElement);
        });

        // Append post container to the HTML posts section
        postedBlogsEl.prepend(postContainerEl);

    });
}

// Add an event listener to the search button or input
document.getElementById("search-bar").addEventListener("input", function() {
    const searchTerm = this.value;
    // Call the function to display filtered blog posts
    displayFilteredBlogPosts(searchTerm);
});
