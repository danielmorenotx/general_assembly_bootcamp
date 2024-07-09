import { Link } from "react-router-dom"
import "./Nav.css"

const Nav = () => {
    return (
        <nav>
            <ul className="nav-list">
                <li><Link to="/">Home</Link></li>
                <li><Link to="/search">Search</Link></li>
                <li><Link to="/history">History</Link></li>
            </ul>
        </nav>
    )
}

export default Nav;