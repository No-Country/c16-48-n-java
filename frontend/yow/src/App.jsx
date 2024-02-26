import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import Navbar1 from './components/Navbar1'
import Faq from './pages/Faq'


function App() {

  return (
    <BrowserRouter>
     <Navbar1/>
      <Routes>
        <Route path='/' element={<HomePage />}></Route>
        <Route path='/faq' element={<Faq />}></Route>

      </Routes>
      <Footer></Footer>
    </BrowserRouter>
  )
}

export default App;
