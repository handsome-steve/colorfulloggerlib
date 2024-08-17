package net.handsomesteve.logger;


/**
 * Utility class providing standardized error message templates for exceptions.
 * This class contains static methods to generate error messages for various types of common
 * programming errors such as null parameters, illegal arguments, and key conflicts, enhancing
 * code readability and maintainability.
 *
 * <p>This class cannot be instantiated.</p>
 *
 * <p>Usage:</p>
 * <pre>{@code
 * // Example use case.
 * Objects.requireNonNull(
 *      identifier,
 *      nonNullParamError_Snippet("identifier", "References.itemOfIdentifier(Identifier)")
 * )
 *
 * // Example use case.
 * Objects.requireNonNull(
 *      identifier,
 *      nonNullGetError_Snippet("identifier", "BlocksRegister.register(Identifier, BlockData)")
 * );
 * }</pre>
 *
 * <p><font color="aqua">
 * This class is extendable to define custom snippets of {@link ExceptionStringSnippets}.
 * </font></p>
 *
 * @author handsome-steve
 * @version 2.1.0
 * @since 2.1.0
 */
public abstract class ExceptionStringSnippets {

    /**
     * Private constructor to prevent instantiation.
     */
    private ExceptionStringSnippets() { throw new AssertionError(); }

    /**
     * Generates a standardized error message for non-null parameter checks.
     *
     * @param param the name of the parameter
     * @param method the method name where the check occurs
     * @return formatted error message
     */
    public static String nonNullParamError_Snippet(String param, String method) {
        return nonNullParam_Snippet("ERROR", param, method, true);
    }

    /**
     * Generates a standardized error message for non-null parameter checks with an option to use StringBuilder.
     *
     * @param param the name of the parameter
     * @param method the method name where the check occurs
     * @param useStringBuilder flag to use StringBuilder for formatting
     * @return formatted error message
     */
    public static String nonNullParamError_Snippet(String param, String method, boolean useStringBuilder) {
        return nonNullParam_Snippet("ERROR", param, method, useStringBuilder);
    }

    /**
     * Generates a customized error message based on provided parameters and formatting preferences.
     *
     * @param outputType the type of output message
     * @param param the name of the parameter
     * @param method the method name where the check occurs
     * @param useStringBuilder flag to use StringBuilder for formatting
     * @return formatted error message
     */
    public static String nonNullParam_Snippet(String outputType, String param, String method, boolean useStringBuilder) {
        if(useStringBuilder)
            return String.format("[%s]: Parameter '%s' must not be null when calling '@%s'.", outputType, param, method);
        return String.format("[%s]: Parameter '%s' must not be null when calling '@%s'.", outputType, param, method);
    }

    /**
     * Generates a standardized error message for non-null target checks.
     *
     * @param target the name of the target instance
     * @param method the method name where the check occurs
     * @return formatted error message
     */
    public static String nonNullGetError_Snippet(String target, String method) {
        return nonNullGet_Snippet("ERROR", target, method, true);
    }

    /**
     * Generates a customized error message for non-null target checks based on output preferences.
     *
     * @param outputType the type of output message
     * @param target the name of the target instance
     * @param method the method name where the check occurs
     * @param useStringBuilder flag to use StringBuilder for formatting
     * @return formatted error message
     */
    public static String nonNullGet_Snippet(String outputType, String target, String method, boolean useStringBuilder) {
        if(useStringBuilder)
            return String.format("[%s]: Target instance of '@%s' must not be null when calling '@%s'.", outputType, target, method);
        return String.format("[%s]: Target instance of '%s' must not be null when calling '@%s'.", outputType, target, method);
    }

    /**
     * Generates an error message for duplicate key exceptions.
     *
     * @param argument the argument involved in the duplication
     * @param instance the instance where the duplication occurred
     * @param target the target context of the duplication
     * @return formatted error message
     */
    public static String keyAlreadyExistsException_Snippet(String argument, String instance, String target) {
        return keyAlreadyExists_Snippet("KeyAlreadyExistsException", argument, instance, target);
    }

    /**
     * Helper method to format messages for key duplication scenarios.
     *
     * @param outputType the type of output message
     * @param argument the argument involved in the duplication
     * @param instance the instance where the duplication occurred
     * @param target the target context of the duplication
     * @return formatted error message
     */
    public static String keyAlreadyExists_Snippet(String outputType, String argument, String instance, String target) {
        return String.format("[%s]: Target instance of '@%s' must not '%s' when adding to '@%s'.", outputType, instance, argument, target);
    }

    /**
     * Generates an error message for illegal argument exceptions.
     *
     * @param argument the incorrect argument
     * @param instance the instance involved
     * @param method the method where the exception occurs
     * @return formatted error message
     */
    public static String illegalArgumentException_Snippet(String argument, String instance, String method) {
        return illegalArgument_Snippet("IllegalArgumentException", argument, instance, method);
    }

    /**
     * Helper method to format messages for illegal argument scenarios.
     *
     * @param outputType the type of output message
     * @param argument the incorrect argument
     * @param instance the instance involved
     * @param method the method where the exception occurs
     * @return formatted error message
     */
    private static String illegalArgument_Snippet(String outputType, String argument, String instance, String method) {
        return String.format("[%s]: Target instance of '@%s' must not '%s' when calling '@%s'.", outputType, instance, argument, method);
    }

    /**
     * Generates an error message for assertion errors.
     *
     * @param argument the assertion argument
     * @param instance the instance involved
     * @param method the method where the assertion error occurs
     * @return formatted error message
     */
    public static String assertionError_Snippet(String argument, String instance, String method) {
        return assertion_Snippet("AssertionError", argument, instance, method);
    }

    /**
     * Helper method to format messages for assertion errors.
     *
     * @param outputType the type of output message
     * @param argument the assertion argument
     * @param instance the instance involved
     * @param method the method where the assertion error occurs
     * @return formatted error message
     */
    private static String assertion_Snippet(String outputType, String argument, String instance, String method) {
        return String.format("[%s]: Target instance of '@%s' cannot be '%s'. Error caught at '@'%s.", outputType, instance, argument, method);
    }
}
