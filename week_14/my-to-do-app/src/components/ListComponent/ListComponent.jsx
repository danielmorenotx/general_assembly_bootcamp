import ButtonComponent from "../ButtonComponent/ButtonComponent";
import { Link } from "react-router-dom";
import "./ListComponent.css"

const ListComponent = ({tasks, handleCompleteTask, handleRemoveTask}) => { // need a list and a button to remove the list item

    return (
        <>
        {tasks.map((task, index) => (
            <div key={task.id} className='task'>
                <p className={task.isCompleted ? "task-complete" : "incomplete"}>
                    <Link to={`/task/${task.id}`}>{task.name}</Link>
                </p>
                
                <div className="button-container">
                    <ButtonComponent buttonName="Done!" buttonType='done' handleClick={() => handleCompleteTask(index)}/>
                    <ButtonComponent buttonName="Delete" buttonType='delete' handleClick={() => handleRemoveTask(index)}/>
                </div>
            </div>
        ))}
        </>
    )
}

export default ListComponent;