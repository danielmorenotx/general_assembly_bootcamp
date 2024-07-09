import "./ButtonComponent.css"

const ButtonComponent = ({buttonName, buttonType, handleClick}) => { // this must be destructured
    // with the name and type from the properties, we set a class and name
    const buttonClass = buttonType === 'add' ? 'add-button' 
    : buttonType === 'delete' ? 'delete-button'
    : buttonType === 'clear' ? 'clear-button'
    : buttonType === 'search' ? 'search-button'
    : buttonType === 'done' ? 'done-button'
    : ''; // Default value if none of the conditions are met

    
    return (
        <button className={buttonClass} onClick={handleClick}>
            {buttonName}
        </button>
    )
}

export default ButtonComponent