import { useState } from "react"
import ButtonComponent from "../../components/ButtonComponent/ButtonComponent"
import "./SearchContainer.css"
import "../Containers.css"

const SearchContainer = ({tasks}) => {
    
    const [inputText, setInputText] = useState("");
    const [searchResults, setSearchResults] = useState([]);

    // --- SEARCH ALL TASKS ---
    const handleSearchAllTasks = () => {
        let filteredTasks = tasks.filter(task =>
          task.name.toLowerCase().includes(inputText.toLowerCase())
        );
        // Log or use filteredTasks as needed
        console.log(filteredTasks);
        setSearchResults(filteredTasks);
        setInputText("");
    };

    return (
        <main className="main-container">
            <h2>Search</h2>
            <input 
                type="text" 
                placeholder='Search for task...' 
                value={inputText} 
                onChange={(e) => setInputText(e.target.value)}
            />
            <ButtonComponent
                buttonName="Search" 
                buttonType='search' 
                handleClick={handleSearchAllTasks}
            />
            <ul className="search-results">
                {searchResults.map((task, index) => (
                <li key={index} className="search-item">
                    <span className="searched-task">{task.name}</span> <span className="searched-task-status">{task.isCompleted ? "completed on " + task.dateCompleted : "added on " + task.dateAdded}</span>
                </li>
                ))}
            </ul>
        </main>

    )
}

export default SearchContainer;