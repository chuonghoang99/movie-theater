package fa.appcode.common.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ValidationErrorResponse extends GenericResponse {

    private static final long serialVersionUID = 1L;

    public List<String> errorMessages;

    public ValidationErrors validationErrors;

    public static class ValidationErrors {
        public List<String> titles;
        public List<Errors> errors;
    }

    public static class Errors implements Serializable {
        private static final long serialVersionUID = 1L;
        public String name;
        public List<String> messages;

        public Errors(String name, String message) {
            this.name = name;
            this.messages = Collections.singletonList(message);
        }

        public Errors(String name, List<String> messages) {
            this.name = name;
            this.messages = messages;
        }

        public Errors() {
        }

        /**
         * To compare equals between 2 Error object
         * When two Error object is equal, they has the same hashCode .
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((messages == null) ? 0 : messages.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        /**
         * To compare equals between 2 Error object.
         * In case of 2 Error have the same error message, keep one Error
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Errors other = (Errors) obj;
            if (messages == null) {
                if (other.messages != null) {
                    return false;
                }
            } else if (!messages.equals(other.messages)) {
                return false;
            }
            if (name == null) {
                return other.name == null;
            } else return name.equals(other.name);
        }

    }
}