import Alert from "react-bootstrap/Alert";
import PropTypes from "prop-types";

const AlertInfo = ({ alertVariant, setAlertVariant, textHeading, text }) => {
  return (
    <Alert
      variant={alertVariant}
      onClose={() => setAlertVariant("")}
      dismissible
    >
      <Alert.Heading>{textHeading}</Alert.Heading>
      {text ? <p>{text}</p> : null }
    </Alert>
  );
};

AlertInfo.propTypes = {
  alertVariant: PropTypes.string.isRequired,
  setAlertVariant: PropTypes.func.isRequired,
  textHeading: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
};
export default AlertInfo;
