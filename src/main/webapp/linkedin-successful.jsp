<div class="text-center">

    <div id="confirm-success" class="modal fade">
        <div class="modal-dialog modal-confirm">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="icon-box">
                        <i class="material-icons">&#xE876;</i>
                    </div>
                    <h4 class="modal-title">Awesome!</h4>
                </div>
                <div class="modal-body">
                    <p class="text-center">Your LinkedIn Profile Link has been added to our system. Click OK to Proceed</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success btn-block" data-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>




    <div class="form-group">
        <label for="linkedin-url" class="col-sm-12 control-label">Please type your LinkedIn Address in the textbox below:</label>
        <div class="col-sm-12">
            <input type="email" class="form-control" id="linkedin-url" placeholder="https://www.linkedin.com/in/[your-unique-linked-in-id]">
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" id="verify-linkedin-button">Verify Your LinkedIn Profile Link</button>
            </div>
        </div>
    </div>

    <div id="verify-linkedin" style="display:none">
        <jsp:include page="/verify-linkedin-page.jsp" />
    </div>

    <!--  -->
</div>



<!-- Modal HTML -->
<div id="confirm-success" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="icon-box">
                    <i class="material-icons">&#xE876;</i>
                </div>
                <h4 class="modal-title">Awesome!</h4>
            </div>
            <div class="modal-body">
                <p class="text-center">Your LinkedIn Profile Link has been added to our system. Click OK to Proceed</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success btn-block" data-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>