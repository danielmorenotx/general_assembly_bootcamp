# React State Management and Hook Exercise
  
### Question 1: State Initialization and Updates
```jsx
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
    setCount(count + 1);
  }

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>Increment</button>
    </div>
  );
}
```
#### What will be the displayed count after the user clicks the `Increment` button once and why?
It will display 'Count: 1'. The state of 'count' is displayed, which is initially 0. On click, the increment function runs. It has two setter calls, but setters are asyncronous. After the function is run, then it renders the setters, both of which are actually setting (0+1), so it will only be 1.

### Question 2: State Updates with Previous State - Read into previous state
```jsx
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(prevCount => prevCount + 1);
    setCount(prevCount => prevCount + 1);
  }

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>Increment</button>
    </div>
  );
}
```
#### How does this implementation differ from the one in Question 1 in terms of the result after clicking `Increment`?
It will increment by 2 every time. The prevCount is a functional update that will use the most recent value.

### Question 3: Direct Mutation of State
```jsx
import React, { useState } from 'react';

function ItemList() {
  const [items, setItems] = useState(["apple", "orange"]);

  const addItem = () => {
    items.push("banana"); // Direct mutation
    setItems(items);
  }

  return (
    <div>
      {items.map((item, index) => <p key={index}>{item}</p>)}
      <button onClick={addItem}>Add Item</button>
    </div>
  );
}
```
#### What is the problem with this code when trying to add a new item, and how should it be corrected?
It is using a push method instead of a spreader. It should have setItems([...items, "banana"]).

### Question 4: Using Spread Operator for State Updates
```jsx
import React, { useState } from 'react';

function ItemList() {
  const [items, setItems] = useState(["apple", "orange"]);

  const addItem = () => {
    setItems([...items, "banana"]); // Correct way
  }

  return (
    <div>
      {items.map((item, index) => <p key={index}>{item}</p>)}
      <button onClick={addItem}>Add Item</button>
    </div>
  );
}
```
#### Explain why the use of the spread operator `...` in this scenario is necessary for correct state management.
A push method directly updates the state array. The spread operator ensures that it remains immutable. Each render receives a new reference now.
