import { useParams } from "react-router-dom"

const TaskDetails = ({ tasks }) => {
    const {taskId} = useParams();

    const task = tasks.find(task => task.id === parseInt(taskId));

    // Render the task details
    return (
        <main className='main-container'>
            <h2>Task Details</h2>
            {task ? (
                <div>
                    <p>Name: {task.name}</p>
                    <p>Status: {task.isCompleted ? "Completed" : "Incomplete"}</p>
                    <p>Date Added: {task.dateAdded}</p>
                    {task.isCompleted && <p>Date Completed: {task.dateCompleted}</p>}
                </div>
            ) : (
                <p>Task not found</p>
            )}
        </main>
    );

};

export default TaskDetails