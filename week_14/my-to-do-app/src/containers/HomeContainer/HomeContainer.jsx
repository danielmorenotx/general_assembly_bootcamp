import ButtonComponent from "../../components/ButtonComponent/ButtonComponent";
import ListComponent from "../../components/ListComponent/ListComponent";
import './HomeContainer.css'

const HomeContainer = ({tasks, inputText, setInputText, onAddTask, onCompleteTask, onRemoveTask, onClearTasks}) => { // implementing the container for the list

    return ( // starting with an empty todo list
        <main className='main-container'>
            <h2>Todo List</h2>
            <section id='tasks-container'>
                <input type="text" placeholder='Add new task...' value={inputText} onChange={(e) => setInputText(e.target.value)}/>
                
                <div id='buttons-container'>
                    <ButtonComponent buttonName='Add Task' buttonType='add' handleClick={onAddTask}/>
                    <ButtonComponent buttonName='Clear All Tasks' buttonType='clear' handleClick={onClearTasks}/>
                </div>

                <div id='task-list'>
                    <ListComponent tasks={tasks} handleCompleteTask={onCompleteTask} handleRemoveTask={onRemoveTask} />
                </div>
            </section>
        </main>
    )

}

export default HomeContainer;