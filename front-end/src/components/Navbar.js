import React, { useEffect, useState } from 'react'
import CategoryService from '../service/CategoryService'
import {Link} from 'react-router-dom'

const Navbar = () => {

    const [categories, setCategories] = useState([])

    useEffect(() => {
        CategoryService.findAllCategories().then(data => setCategories(data))    
    },[])
    

    return (
        <>
        {
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">Navbar</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to="/categories">Categories</Link>
                        </li>
                    </ul>
                    <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
                        {categories.map(
                            (category, index) => 
                            <li className="nav-item" key={index}>
                                <a className="nav-link" aria-current="page" href="#">{category.name}</a>
                            </li>
                        )}
                    </ul>

                </div>
            </div>
            </nav>
            
        }
        </>
    )
}

export default Navbar