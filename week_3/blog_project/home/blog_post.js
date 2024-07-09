// ----- VARIABLES -----
document.addEventListener("DOMContentLoaded",handleDarkModeChange);
document.addEventListener("DOMContentLoaded",isDarkMode)
console.log(localStorage.getItem("darkMode"));

document.addEventListener("DOMContentLoaded",handleDarkModeChange);
const usernameElement = document.getElementById("account-username")
usernameElement.textContent = localStorage.getItem("username")


// -- blog --
const postTitleEl = document.getElementById("post-title");
const postBodyEl = document.getElementById("post-body");
const postTagsEl = document.getElementById("post-tags");
const postedBlogsEl = document.getElementById("blog-section")
const postBlogBtn = document.getElementById("post-button")

let blogPosts = [
    // {
    //     title: "First post",
    //     body: "all the insights",
    //     tags: "tag",
    //     timestamp: ,
    //     comments: [
    //         {
    //             username: "username",
    //             commentText: "this is great"
    //         },{
    //             username: "username2",
    //             commentText: "great job"
    //         }
    //     ]
    // }
]
let filteredPosts = []


// ----- EVENT LISTENERS -----
postBlogBtn.addEventListener("click",postBlogObject);

// -- hamburger menu --
document.querySelector(".menu-btn").addEventListener("click", () => {
    document.querySelector(".nav-links").classList.toggle("active");

});


// ----- FUNCTIONS -----
// -- post a blog --
function postBlogObject() {
    
    const postId = blogPosts.length + 1;
    const timePosted = new Date().toISOString()
    let newPost = {
        id: postId,
        title: postTitleEl.value,
        body: postBodyEl.value,
        timestamp: timePosted,
        // tags: postTagsEl.value.split(",")
        comments: [

        ]
    }

    console.log(timePosted)

    //add post object to blog post lists
    blogPosts.push(newPost)

    //clear text area after posting
    postTitleEl.value = ""
    postBodyEl.value = ""
    // postTagsEl.value = "tags..."
    // postTagsEl.style.color = "gray"

    // createCommentsSection(postId)

    displayBlogPosts()
}

// -- display blog posts --
function displayBlogPosts() {
    // clear blog post section every time a new blog is posted
    postedBlogsEl.innerHTML = "";

    // iterate through every object in the blog_posts array
    blogPosts.forEach(post => {
        const postContainerEl = document.createElement("article");
        const blogTitleEl = document.createElement("h2");
        blogTitleEl.setAttribute("class","article-title");
        const blogBodyEl = document.createElement("p");
        // const blogTagsEl = document.createElement("p")

        //add class to post container
        postContainerEl.classList.add("column-format")
        
        //assign values to the elements
        blogTitleEl.textContent = post.title;
        blogBodyEl.textContent = post.body;
        // blogTagsEl = post.tags;

        //append post elements to the container
        postContainerEl.appendChild(blogTitleEl);
        postContainerEl.appendChild(blogBodyEl);
        // postContainerEl.appendChild(blogTagsEl);

        // creates a comments section
        createCommentsSection(postContainerEl, post.id)

        //append comments to the container
        post.comments.forEach(comment => {
            const commentElement = document.createElement("div");
            commentElement.classList.add("comment");
            commentElement.innerHTML = `<h5>${comment.username}</h5><p>${comment.commentText}</p>`;
            postContainerEl.appendChild(commentElement);
        });

        //append post container to the HTML posts section
        postedBlogsEl.prepend(postContainerEl);

    })
}

function createCommentsSection(postContainerEl, postId) {
    const commentsSectionEl = document.createElement("section");
    commentsSectionEl.setAttribute("id","comments-section");
    commentsSectionEl.classList.add("column-format");
    
    const commentTextArea = document.createElement("textarea");
    commentTextArea.setAttribute("name","comment");
    commentTextArea.setAttribute("placeholder","Write comment here");
    commentTextArea.classList.add("write-comment");
    commentTextArea.setAttribute("rows","2");
    commentTextArea.setAttribute("data-blog-post-id", postId); // Add event listener here
    commentsSectionEl.appendChild(commentTextArea);
    
    const postCommentBtn = document.createElement("button")
    postCommentBtn.classList.add("comment-button")
    postCommentBtn.setAttribute("data-blog-post-id", postId) // change to the dynamic
    postCommentBtn.textContent = "Post Comment"
    commentsSectionEl.appendChild(postCommentBtn)

    //appending a comments section
    postContainerEl.appendChild(commentsSectionEl);

    const commentButton = postContainerEl.querySelector(`button[data-blog-post-id="${postId}"]`);
    commentButton.addEventListener("click", postComment);
}


// -- dark mode --
const darkModeSwith = document.getElementById("light-switch")
darkModeSwith.addEventListener("change",toDarkMode)


function toDarkMode() {
    const currentLight = document.body.classList.contains("dark-mode");
    if (currentLight) {
        localStorage.setItem("darkMode","disabled")    
    } else {
        localStorage.setItem("darkMode","enabled")
    }

    document.body.classList.toggle("dark-mode");
}

function handleDarkModeChange() {
    const darkModePreference = localStorage.getItem('darkMode');
    console.log(darkModePreference)

    if (darkModePreference === 'enabled') {
      document.body.classList.toggle('dark-mode')
  }
}

function isDarkMode() {
    if (localStorage.getItem("darkMode") === "enabled") {
        darkModeSwith.checked = true;
    } else {
        darkModeSwith.checked = false;
    }
}

// -- login credentials --
const username = localStorage.getItem("username")
const password = localStorage.getItem("password")