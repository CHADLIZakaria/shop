import './App.css';
import Navbar from './components/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import ListProducts from './components/ListProducts';
import ListCategories from './components/ListCategories';
import FormCategory from './components/category/FormCategory';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<ListProducts />} />
        <Route path="/products" element={<ListProducts />} />
        <Route path="/categories" element={<ListCategories />} />
        <Route path="/category/:id/edit" element={<FormCategory />} />
        
      </Routes>
    </Router>
  );
}

export default App;
