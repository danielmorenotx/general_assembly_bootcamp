fetch("https://api.spoonacular.com/recipes/random?apiKey=9654613890584fc499cb6c499651a004")
    .then(response => response.json())
    .then(data => {
           loadRandomRecipe(data);
})
    .catch(error => console.error("There was an error!", error))

function loadRandomRecipe(data) {
    const randomRecipe = data.recipes[0];

    // create variables from data
    const recipeAside = document.getElementById("recipe-aside")
    const recipeTitle = randomRecipe.title;
    const recipePicture = randomRecipe.image;
    const recipeSourceUrl = randomRecipe.sourceUrl;

    // create elements for each variable
    const recipeContainerEl = document.createElement("div");
    recipeContainerEl.classList.add("column-format");
    recipeContainerEl.setAttribute("id","recipe-container");
    
    const recipeTitleEl = document.createElement("h4");
    recipeTitleEl.classList.add("recipe-title")
    recipeTitleEl.textContent = recipeTitle;
    
    const recipeImgEl = document.createElement("img");
    recipeImgEl.setAttribute("src",recipePicture);
    recipeImgEl.setAttribute("alt","recipe picture");
    recipeImgEl.setAttribute("id","recipe-picture")

    const getRecipeBtn = document.createElement("button");
    getRecipeBtn.setAttribute("id","get-recipe-button");
    getRecipeBtn.textContent = "Get the recipe here!"
    getRecipeBtn.addEventListener("click",function() {
        window.open(recipeSourceUrl,"_blank");
    });

    // append elements to html
    recipeAside.appendChild(recipeContainerEl);
    recipeContainerEl.appendChild(recipeTitleEl);
    recipeContainerEl.appendChild(recipeImgEl);
    recipeContainerEl.appendChild(getRecipeBtn);

}

// loadRandomRecipe(mockData)

