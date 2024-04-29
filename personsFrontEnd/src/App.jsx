import { useState } from "react";
import personRegister from "./services/personRegister";
import PersonForm from "./components/PersonForm";
import PersonInformation from "./components/PersonInformation";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const App = () => {
  const [person, setPerson] = useState({
    firstName: "",
    lastName: "",
    socialSecurityNumber: "",
    phoneNumber: "",
    address: {
      street: "",
      postalCode: "",
      city: "",
    },
  });

  const clearForm = () => {
    setPerson({
      firstName: "",
      lastName: "",
      socialSecurityNumber: "",
      phoneNumber: "",
      address: {
        street: "",
        postalCode: "",
        city: "",
      },
    });
  };

  const handleChangeBasicInfo = (e) => {
    const { name, value } = e.target;
    setPerson({ ...person, [name]: value });
  };

  const handleChangeAddressInfo = (e) => {
    const { name, value } = e.target;
    setPerson({ ...person, address: { ...person.address, [name]: value } });
  };

  const addPerson = (e) => {
    e.preventDefault();
    const newPerson = {
      firstName: person.firstName,
      lastName: person.lastName,
      socialSecurityNumber: person.socialSecurityNumber,
      phoneNumber: person.phoneNumber,
      address: {
        street: person.address.street,
        postalCode: person.address.postalCode,
        city: person.address.city,
      },
    };

    personRegister.create(newPerson).then(() => {});
    clearForm();
  };

  return (
    <>
      <Router>
        <Navbar bg="primary" data-bs-theme="dark" style={{ marginBottom: 20 }}>
          <Nav.Link as={Link} style={{ padding: 10 }} to="/">
            PERSON REGISTER
          </Nav.Link>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link
                as={Link}
                style={{ padding: 10 }}
                to="/personInformation"
              >
                Person information
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
        <Container>
          <Routes>
            <Route
              path="/"
              element={
                <PersonForm
                  person={person}
                  addPerson={addPerson}
                  handleChangeBasicInfo={handleChangeBasicInfo}
                  handleChangeAddressInfo={handleChangeAddressInfo}
                />
              }
            />
            <Route path="/personInformation" element={<PersonInformation />} />
          </Routes>
        </Container>
      </Router>
    </>
  );
};

export default App;
