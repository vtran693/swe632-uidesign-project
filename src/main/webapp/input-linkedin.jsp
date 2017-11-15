<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="verify-linkedin-label">Looking for Your LinkedIn Profile</h4>
        </div>
        <div class="modal-body">

            <div class="form-group">
                <div id="linkedin-error-label" class="col-md-12 alert alert-danger" role="alert" style="display:none">Don't fool us! Your LinkedIn link is invalid!</div>

                <label for="linkedin-url" class="col-md-12 control-label">Please type your LinkedIn Address in the textbox below:</label>
                <div class="col-md-12">
                    <input type="email" class="form-control col-md-6" id="linkedin-url" placeholder="https://www.linkedin.com/in/[your-linkedin-id]">
                </div>
                <span id="verify-process-tag-linkedin" class="label label-primary" style="display:none">Verifying...</span>
            </div>

            <div id="verify-linkedin" style="display:none">
                <jsp:include page="/verify-linkedin-page.jsp" />
            </div>

            <div class="row">
                <div class="col-md-2">
                    <button class="btn btn-primary" id="verify-linkedin-button">Verify Link</button>
                </div>
                <div class="col-md-8">
                    <button type="button" class="btn btn-warning" data-dismiss="modal"> Not Now</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="text-center">




    <!--  -->
</div>