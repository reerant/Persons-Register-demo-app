import PropTypes from "prop-types";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";

const PersonForm = ({
  person,
  addPerson,
  handleChangeBasicInfo,
  handleChangeAddressInfo,
}) => {
  return (
    <>
      <Form onSubmit={addPerson}>
        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridFirstName">
            <Form.Label>Firstname</Form.Label>
            <Form.Control
              type="text"
              name="firstName"
              placeholder="Enter firstname"
              value={person.firstName}
              onChange={handleChangeBasicInfo}
            />
          </Form.Group>
          <Form.Group as={Col} controlId="formGridLastName">
            <Form.Label>Lastname</Form.Label>
            <Form.Control
              type="text"
              name="lastName"
              placeholder="Enter lastname"
              value={person.lastName}
              onChange={handleChangeBasicInfo}
            />
          </Form.Group>
        </Row>
        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridSocialSecurityNumber">
            <Form.Label>Social security number</Form.Label>
            <Form.Control
              type="text"
              name="socialSecurityNumber"
              placeholder="Enter social security number"
              value={person.socialSecurityNumber}
              onChange={handleChangeBasicInfo}
            />
          </Form.Group>
          <Form.Group as={Col} controlId="formGridLastName">
            <Form.Label>Phone number</Form.Label>
            <Form.Control
              type="text"
              name="phoneNumber"
              placeholder="Enter phone number"
              value={person.phoneNumber}
              onChange={handleChangeBasicInfo}
            />
          </Form.Group>
        </Row>
        <Form.Group></Form.Group>
        <Form.Group className="mb-3" controlId="formGridStreet">
          <Form.Label>Street</Form.Label>
          <Form.Control
            type="text"
            name="street"
            placeholder="Enter street"
            value={person.address.street}
            onChange={handleChangeAddressInfo}
          />
        </Form.Group>
        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridPostalCode">
            <Form.Label>Postal code</Form.Label>
            <Form.Control
              type="text"
              name="postalCode"
              placeholder="Enter postal code"
              value={person.address.postalCode}
              onChange={handleChangeAddressInfo}
            />
          </Form.Group>
          <Form.Group as={Col} controlId="formGridCity">
            <Form.Label>City</Form.Label>
            <Form.Control
              type="text"
              name="city"
              placeholder="Enter city"
              value={person.address.city}
              onChange={handleChangeAddressInfo}
            />
          </Form.Group>
        </Row>
        <Button variant="primary" type="submit" style={{ marginTop: 20 }}>
          Submit
        </Button>
      </Form>
    </>
  );
};

PersonForm.propTypes = {
  person: PropTypes.object.isRequired,
  addPerson: PropTypes.func.isRequired,
  handleChangeBasicInfo: PropTypes.func.isRequired,
  handleChangeAddressInfo: PropTypes.func.isRequired,
};

export default PersonForm;
