import "./HistoryContainer.css"

const HistoryContainer = ({tasks}) => {

    return (
        <main className="main-container">
            <h2>History</h2>
            <ul className="history-list">
                {tasks.map((task, index) => {
                    return (
                        <li key={index} className="history-item">
                            <span>{task.name}</span>
                            <span className={task.isCompleted ? "completed" : "pending"}>
                                {task.isCompleted ? "completed" : "pending"}
                            </span>
                        </li>)})
                }
            </ul>
        </main>
    )
}

export default HistoryContainer