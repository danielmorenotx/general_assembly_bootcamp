import { useState } from 'react';
import { BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import Header from './components/Header/Header';
import Nav from './components/Nav/Nav';
import HistoryContainer from './containers/HistoryContainer/HistoryContainer';
import HomeContainer from './containers/HomeContainer/HomeContainer';
import SearchContainer from './containers/SearchContainer/SearchContainer';
import ErrorPage from './components/ErrorPage/ErrorPage';
import TaskDetails from './components/TaskDetails/TaskDetails';
import { ThemeContext } from './contexts/ThemeContext';
import './App.css';
// import TaskDetails from './components/TaskDetails/TaskDetails';

const App = () => {

  // set initial states of the container and of text content
  const [tasks, setTasks] = useState([]) // initial state of a todo list is empty
  const [inputText, setInputText] = useState("") // initial input text is empty
  const [nextId, setNextId] = useState(1);
  const [theme, setTheme] = useState("light")

  // ===== HANDLE METHODS =====
  // --- ADD TODO ---
  const handleAddTask = () => {

    if (inputText.trim() !== '') { // if the input text isn't blank
      const currentDate = new Date().toLocaleDateString('en-US');
      const newTask = {
        id: nextId,
        name: inputText,
        isCompleted: false,
        dateAdded: currentDate,
        dateCompleted: null
      };
      setTasks([...tasks, newTask]); // add the new input to the list of todos
      setNextId(nextId + 1);
      setInputText(''); // then clear the input field
    };
  };

  // --- COMPLETE TASK ---
  const handleCompleteTask = (index) => {
    const dateCompleted = new Date().toLocaleDateString('en-US');
    const updatedTasks = tasks.map((task, i) => {
      if (i === index) {
        return {
          ...task,
          isCompleted:true,
          dateCompleted: dateCompleted};
      }
      return task;
    })

    setTasks(updatedTasks);
  }

  // --- REMOVE TODO ---
  const handleRemoveTask = (index) => {
    const updatedTasks = tasks.filter((task, i) => i !== index);
    setTasks(updatedTasks);
  };

  // --- DELETE ALL TODOS ---
  const handleClearTasks = () => {
    setTasks([]); // sets the Todo list to nothing
  };

  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
    <BrowserRouter>
    <Header toDoCount={tasks.length}/>
    <Nav />
    <Routes>
      <Route 
        path='/' 
        element={<HomeContainer 
          tasks={tasks} 
          inputText={inputText} 
          setInputText={setInputText}
          onAddTask={handleAddTask}
          onCompleteTask={handleCompleteTask}
          onRemoveTask={handleRemoveTask}
          onClearTasks={handleClearTasks}/>}
      />
      <Route 
        path='/search' 
        element={<SearchContainer 
          tasks={tasks}/>}/>
      <Route 
        path='/history'
        element={<HistoryContainer
          tasks={tasks}/>}/>
      <Route 
        path='/task/:taskId'
        element={<TaskDetails 
          tasks={tasks}/>}/>
      <Route 
        path='/*'
        element={<ErrorPage/>}/>
    </Routes>
    </BrowserRouter>
    </ThemeContext.Provider>
  )
}

export default App
