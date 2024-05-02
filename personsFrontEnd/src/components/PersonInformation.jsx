import { useState } from "react";
import PropTypes from "prop-types";
import personRegister from "../services/personRegister";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

//show one person information, update info or delete person from register
const PersonInformation = ({ setAlertVariant }) => {
  const [formInput, setFormInput] = useState("");
  const [personInfo, setPersonInfo] = useState("");
  const [showPersonInfo, setShowPersonInfo] = useState(false);

  const handleInput = (e) => {
    setFormInput(e.target.value);
  };

  const handleUpdatePhoneNumber = (e) => {
    const { name, value } = e.target;
    setPersonInfo({ ...personInfo, [name]: value });
  };
  const handleUpdateAddress = (e) => {
    const { name, value } = e.target;
    setPersonInfo({
      ...personInfo,
      address: { ...personInfo.address, [name]: value },
    });
  };

  const getPersonBySocialSecurityNumber = (e) => {
    e.preventDefault();
    personRegister
      .getOneBySocialSecurityNumber(formInput)
      .then((returnedPerson) => {
        setPersonInfo(returnedPerson);
        setShowPersonInfo(true);
      })
      .catch((e) => {
        if (e.response.status === 404) {
          setAlertVariant("secondary");
        }
      });

    setFormInput("");
  };

  const updateInfo = (e) => {
    e.preventDefault();
    personRegister
      .update(personInfo.id, personInfo)
      .then(() => {
        setAlertVariant("success");
        setShowPersonInfo(false);
        setFormInput("");
      })
      .catch(() => {
        setAlertVariant("warning");
      });
  };

  const deletePerson = (id, firstName, lastName) => {
    if (
      window.confirm(
        `Do you really want to delete ${firstName} ${lastName} from Person Register?`
      )
    ) {
      personRegister
        .remove(id)
        .then(() => {
          setShowPersonInfo(false);
        })
        .catch(() => {
          setAlertVariant("danger");
        });
    }
  };

  return (
    <>
      <div>
        <Form onSubmit={getPersonBySocialSecurityNumber}>
          <Form.Group className="mb-3" controlId="formSearch">
            <Form.Label>Search for person</Form.Label>
            <Form.Control
              type="text"
              placeholder="Give social security number"
              value={formInput}
              onChange={handleInput}
            />
          </Form.Group>
          <Button variant="primary" type="submit" style={{ marginBottom: 20 }}>
            Find
          </Button>
        </Form>
      </div>
      {showPersonInfo ? (
        <div>
          <div
            style={{
              textTransform: "uppercase",
              marginBottom: 10,
              marginTop: 20,
            }}
          >
            {personInfo.firstName}, {personInfo.lastName}{" "}
            {personInfo.socialSecurityNumber}
          </div>

          <Form onSubmit={updateInfo}>
            <Form.Label>Update phone number or address.</Form.Label>
            <Form.Group className="mb-3" controlId="formUpdatePhoneNumber">
              <Form.Label>Phone number</Form.Label>
              <Form.Control
                type="text"
                name="phoneNumber"
                value={personInfo.phoneNumber}
                onChange={handleUpdatePhoneNumber}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formUpdateStreet">
              <Form.Label>Street</Form.Label>
              <Form.Control
                type="text"
                name="street"
                value={personInfo.address.street}
                onChange={handleUpdateAddress}
              />
            </Form.Group>
            <Row className="mb-3">
              <Form.Group as={Col} controlId="formUpdatePostalCode">
                <Form.Label>Postal code</Form.Label>
                <Form.Control
                  type="text"
                  name="postalCode"
                  value={personInfo.address.postalCode}
                  onChange={handleUpdateAddress}
                />
              </Form.Group>
              <Form.Group as={Col} controlId="formUpdateCity">
                <Form.Label>City</Form.Label>
                <Form.Control
                  type="text"
                  name="city"
                  value={personInfo.address.city}
                  onChange={handleUpdateAddress}
                />
              </Form.Group>
            </Row>
            <Button variant="primary" type="submit" style={{ marginRight: 10 }}>
              Submit
            </Button>
            <Button
              variant="primary"
              style={{ marginRight: 10 }}
              onClick={() => setShowPersonInfo(false)}
            >
              Clear
            </Button>
            <Button
              variant="primary"
              style={{ marginRigth: 10 }}
              onClick={() =>
                deletePerson(
                  personInfo.id,
                  personInfo.firstName,
                  personInfo.lastName
                )
              }
            >
              Delete
            </Button>
          </Form>
        </div>
      ) : null}
    </>
  );
};
PersonInformation.propTypes = {
  setAlertVariant: PropTypes.func.isRequired,
};
export default PersonInformation;
