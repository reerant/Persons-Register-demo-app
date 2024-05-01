import PropTypes from "prop-types";
import Alert from "react-bootstrap/Alert";

const AlertNotification = ({ alertVariant, setAlertVariant }) => {
  if (alertVariant === "primary") {
    return (
      <Alert variant="primary" onClose={() => setAlertVariant("")} dismissible>
        <Alert.Heading>The form was submitted successfully.</Alert.Heading>
      </Alert>
    );
  } else if (alertVariant === "danger") {
    return (
      <Alert variant="danger" onClose={() => setAlertVariant("")} dismissible>
        <Alert.Heading>Unable to submit form. </Alert.Heading>
        <p>Check that all fields are filled in.</p>
      </Alert>
    );
  } else if (alertVariant === "secondary") {
    return (
      <Alert
        variant="secondary"
        onClose={() => setAlertVariant("")}
        dismissible
      >
        <Alert.Heading>No data found with given information. </Alert.Heading>
      </Alert>
    );
  } else {
    return null;
  }
};

AlertNotification.propTypes = {
  alertVariant: PropTypes.string.isRequired,
  setAlertVariant: PropTypes.func.isRequired,
};

export default AlertNotification;
