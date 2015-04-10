<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <title>Luo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="hyvinvointi" />

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/create.css" rel="stylesheet">
    <link href="recources/js/bootstrap-responsive.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->



</head>
<body>
<div class="container">
      <div class="row clearfix">
        <div class="col-md-6">
          <div class="clearfix">
            <h2>Luo lomake</h2>
            <hr>
            <div id="build">
              <form id="target" class="form-horizontal">
                <fieldset>
                  <div id="legend" class="component" rel="popover" title="Form Title" trigger="manual"
                    data-content="
                    <form class='form'>
                      <div class='form-group col-md-12'>
                        <label class='control-label'>Title</label> <input class='form-control' type='text' name='title' id='text'>
                        <hr/>
                        <button class='btn btn-info'>Save</button><button class='btn btn-danger'>Cancel</button>
                      </div>
                    </form>" data-html="true"
                    >
                    <legend class="valtype" data-valtype="text">Lomakkeen nimi</legend>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
        </div>

        <div class="col-md-6">
            <h2>Drag & Drop komponentit</h2>
            <hr>
          <div class="tabbable">
            <form class="form-horizontal" id="components">
              <fieldset>
                <div class="tab-content">

                  <div class="tab-pane active" id="1">


                    <div class="form-group component" rel="popover" title="Search Input" trigger="manual"
                      data-content="
                      <form class='form'>
                        <div class='form-group col-md-12'>
                          <label class='control-label'>Label Text</label> <input class='form-control' type='text' name='label' id='label'>
                          <hr/>
                          <button class='btn btn-info'>Save</button><button class='btn btn-danger'>Cancel</button>
                        </div>
                      </form>" data-html="true" 
                      >

                      <!-- Textarea -->
                      <label class="col-md-4 control-label valtype" data-valtype="label">Textarea</label>
                      <div class="col-md-4">
                        <div class="textarea">
                              <textarea class="form-control valtype" data-valtype="checkbox" /> </textarea>
                        </div>
                      </div>
                    </div>                 


                    <div class="form-group component" rel="popover" title="Multiple Checkboxes" trigger="manual"
                      data-content="
                      <form class='form'>
                        <div class='form-group col-md-12'>
                          <label class='control-label'>Label Text</label> <input class='form-control' type='text' name='label' id='label'>
                          <label class='control-label'>Options: </label>
                          <textarea class='form-control' style='min-height: 200px' id='checkboxes'> </textarea>
                          <hr/>
                          <button class='btn btn-info'>Save</button><button class='btn btn-danger'>Cancel</button>
                        </div>
                      </form>" data-html="true"
                      >
                      <label class="col-md-4 control-label valtype" data-valtype="label">Checkboxes</label>
                      <div class="col-md-4 valtype" data-valtype="checkboxes">

                        <!-- Multiple Checkboxes -->
                        <label class="checkbox">
                          <input type="checkbox" value="Option one">
                          Option one
                        </label>
                        <label class="checkbox">
                          <input type="checkbox" value="Option two">
                          Option two
                        </label>
                      </div>

                    </div>

                    <div class="form-group component" rel="popover" title="Multiple Radios" trigger="manual"
                      data-content="
                      <form class='form'>
                        <div class='form-group col-md-12'>
                          <label class='control-label'>Label Text</label> <input class='form-control' type='text' name='label' id='label'>
                          <label class='control-label'>Group Name Attribute</label> <input class='form-control' type='text' name='name' id='name'>
                          <label class='control-label'>Options: </label>
                          <textarea class='form-control' style='min-height: 200px' id='radios'></textarea>
                          <hr/>
                          <button class='btn btn-info'>Save</button><button class='btn btn-danger'>Cancel</button>
                        </div>
                      </form>" data-html="true"
                      >
                      <label class="col-md-4 control-label valtype" data-valtype="label">Radio buttons</label>
                      <div class="col-md-4 valtype" data-valtype="radios">

                        <!-- Multiple Radios -->
                        <label class="radio">
                          <input type="radio" value="Option one" name="group" checked="checked">
                          Option one
                        </label>
                        <label class="radio">
                          <input type="radio" value="Option two" name="group">
                          Option two
                        </label>
                      </div>

                    </div>
                    <!-- Piilotettiin toi koodi ku se on vaa nörteille -->              
					<div>
                    <textarea id="source" class="col-md-12"></textarea>
                    </div>
                </fieldset>
              </form>
            </div>
          </div> <!-- row -->
      <div class="row clearfix">
        <div class="col-md-12"></div>
      </div>
      <button type="submit" class="btn btn-primary">Tallenna</button>
    </div><!-- /container -->
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/fb.js"></script>
</body>
</html>