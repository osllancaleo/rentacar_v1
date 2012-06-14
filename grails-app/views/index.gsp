<!doctype html>

<html>
	<head>

                <meta name="layout" content="main"/>
		<title>rentacar .:. Sistema de Gestion de Rent a Car</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
            <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.js')}"></script>
            <script type="text/javascript">
              $(document).ready(function() {
                cargaMenu()

              });
              function cargaMenu() {
            $('#status').html('');
            $.getJSON('${createLink(controller:"menu",action:"ListMenuJson")}', function(d) {
                if (d.listaMenu > "0") {
                    $.each(d.listaMenu, function(i, city) {
                       // createListCities(city);
                       var mensajeHTML = $('<br> <div id ="'+city.nombre+'"><a href="'+city.nombre+'" >'+city.nombre+'</a></div>');
                        $('#status').append(mensajeHTML);

                    });
                }
            });
        }


              </script>

	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">

		<h2>Menu Principal</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						
                                          <g:if test="${c.name != 'Login' }">
                                            <g:if test="${c.name != 'Logout'}">
                                          <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
                                            </g:if>
                                          </g:if>
					</g:each>
				</ul>
                  <!--	<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
                        -->
		</div>
		<div id="page-body" role="main">
		<br/><br/><br/>
                
                  <h1>Bienvenido a "Rent a Car"</h1>
			<p>Rent a Car es un nuevo sistema de gestion de alquiler de vehiculos.
			</p>

			<div id="controller-list" role="navigation">
				
			</div>
		</div>
	</body>
</html>
