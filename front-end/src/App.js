import './App.css';
import Navbar from './components/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import ListProducts from './components/ListProducts';
import FormCategory from './components/category/FormCategory';
import Sidebar from './components/sidebar/Sidebar';
import Categories from './pages/categories';
import Layout from './components/Layout';

function App() {
  return (
    <Router>
      <Layout>
          <Sidebar />
          <Routes>
            <Route path="/categories" element={<Categories />} />
            <Route path="/category/:id/edit" element={<FormCategory />} />
            <Route path="categories/:name" element={<ListProducts />} key={window.location.pathname} />
          </Routes>
      </Layout>
    </Router>
  );
}

export default App;
