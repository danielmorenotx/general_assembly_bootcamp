import { LuListTodo } from "react-icons/lu";
import "./Header.css"

const Header = ({toDoCount}) => {
    return (
        <header>
            <h1>Get Things Done</h1>
            <div>
                <LuListTodo size={"3em"}/>
                {toDoCount > 0 && <span className="todo-count">{toDoCount}</span>}
            </div>
            <button >Dark Mode </button>
        </header>
    )
}

export default Header