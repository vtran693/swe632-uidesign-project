
    <div class="row">

        <div class="col-md-6">
            <p>SWE 645</p>
            <p>Status: Registered</p>
        </div>
        <div class="col-md-6">
            <a id="modify-more-info-button" class="btn icon-btn btn-warning" href="#">
                <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-warning"></span> More Info </a>
            <a id="modify-delete-button" class="btn icon-btn btn-danger" href="#">
                <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> Delete </a>
        </div>
        <div id="modify-delete-message-template" style="display:none">
            <jsp:include page="/delete-message.jsp"/>
        </div>

        <div id="modify-more-info-message-template" style="display:none">
            <jsp:include page="/class-message.jsp"/>
        </div>

    </div>


