package com.vgen.vooop.execption

private const val BAD_REQUEST_ERROR_MESSAGE = "Bad Request!"
private const val FORBIDDEN_ERROR_MESSAGE = "Forbidden!"
private const val NOT_FOUND_ERROR_MESSAGE = "Not Found!"
private const val METHOD_NOT_ALLOWED_ERROR_MESSAGE = "Method Not Allowed!"
private const val CONFLICT_ERROR_MESSAGE = "Conflict!"
private const val UNAUTHORIZED_ERROR_MESSAGE = "Unauthorized!"
private const val INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server error!"
private const val NO_CONNECTION_ERROR_MESSAGE = "No Connection!"
private const val TIMEOUT_ERROR_MESSAGE = "Time Out!"
const val UNKNOWN_ERROR_MESSAGE = "Unknown Error!"


data class ApiError(val message: String?, val code: Int?, var errorStatus: ErrorStatus) {

    constructor(message: String?, errorStatus: ErrorStatus) : this(message, null, errorStatus)

    fun errorMessage(): String {
        return when (errorStatus) {
            ErrorStatus.BadRequest -> BAD_REQUEST_ERROR_MESSAGE
            ErrorStatus.Forbidden -> FORBIDDEN_ERROR_MESSAGE
            ErrorStatus.NotFound -> NOT_FOUND_ERROR_MESSAGE
            ErrorStatus.MethodNotAllowed -> METHOD_NOT_ALLOWED_ERROR_MESSAGE
            ErrorStatus.Conflict -> CONFLICT_ERROR_MESSAGE
            ErrorStatus.Unauthorized -> UNAUTHORIZED_ERROR_MESSAGE
            ErrorStatus.InternalServerError -> INTERNAL_SERVER_ERROR_MESSAGE
            ErrorStatus.NoConnection -> NO_CONNECTION_ERROR_MESSAGE
            ErrorStatus.Timeout -> TIMEOUT_ERROR_MESSAGE
            ErrorStatus.UnknownError -> UNKNOWN_ERROR_MESSAGE
        }
    }

    /**
     * Various error status to know what happened if something goes wrong with a repository call
     */
    sealed interface ErrorStatus {
        /**
         * Any case where a parameter is invalid, or a required parameter is missing.
         * This includes the case where no OAuth token is provided and
         * the case where a resource ID is specified incorrectly in a path.
         */
        data object BadRequest : ErrorStatus

        /**
         * The OAuth token was provided but was invalid.
         */
        data object Unauthorized : ErrorStatus

        /**
         * The requested information cannot be viewed by the acting user, for example,
         * because they are not friends with the user whose data they are trying to read.
         * It could also indicate privileges or access has been revoked.
         */
        data object Forbidden : ErrorStatus

        /**
         * Endpoint does not exist.
         */
        data object NotFound : ErrorStatus

        /**
         * Attempting to use POST with a GET-only endpoint, or vice-versa.
         */
        data object MethodNotAllowed : ErrorStatus

        /**
         * The request could not be completed as it is. Use the information included in the response to modify the request and retry.
         */
        data object Conflict : ErrorStatus

        /**
         * There is either a bug on our side or there is an outage.
         * The request is probably valid but needs to be retried later.
         */
        data object InternalServerError : ErrorStatus

        /**
         * Time out  error
         */
        data object Timeout : ErrorStatus

        /**
         * Error in connecting to repository (Server or Database)
         */
        data object NoConnection : ErrorStatus

        /**
         * When error is not known
         */
        data object UnknownError : ErrorStatus
    }
}