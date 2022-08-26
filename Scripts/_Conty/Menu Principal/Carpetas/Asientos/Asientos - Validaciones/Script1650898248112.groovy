import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime

/**
 * Fecha creacion : 25-04-2022
 * QA : Santiago Marrugo
 */
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'), null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(1)
//Obtenemos la fecha actual, para extraer solo el mes y año y ese valor pasarlo como parametro al mes que vamos a crear
String fechaCorriente = LocalDateTime.now()
println(fechaCorriente)
//2022-04-08T14:34:02.206
String mes = fechaCorriente.substring(5, 7)
println(mes)
String anio = fechaCorriente.substring(0, 4)
println(anio)
//Fecha que se va a pasar como parametro para crear el mes de asiento
String fechaAsientoCrear = (mes + '/') + anio
println(fechaAsientoCrear)
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), fechaAsientoCrear)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)
String asientoMesNuevo = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelDentrodelAsiento'))
println(asientoMesNuevo)
asientoMesNuevo = asientoMesNuevo.substring(9, 16)
//Comprobamos el mes de asiento correcto
assert fechaAsientoCrear == asientoMesNuevo
//No ubicamos en la primera celda de la grilla
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)
//Obtenemos el valor de la primera celda, es decir en donde esta la celda seleccionada
String primeraCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(primeraCelda)
assert primeraCelda == '[[0, 5, 0, 5]]'

println('<----- ID 1 ----->')
//Vamos a agregar los Asientos
//Ingresamos los datos del primer asiento de una linea
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"10")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,7,"41113")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"PruebaPrimerAsiento")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,13,"2")', null)
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"C")', null)
//Validamos el primer asiento de una linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
//Agregamos una nueva linea de asiento de una sola linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)

println('<----- ID 2 ----->')
//Vamos a dejar la celda del Libro vacia
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"10")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"41113")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,10,"PruebaSegundoAsiento")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,13,"2")', null)
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
//Se borra el dato que corresponde al libro a donde pertenece el asiento
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))
//Hacemos click el el boton terminar para validar el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Aviso: "La fila de un asiento está incompleta y no se guardará el cambio."', false)
WebUI.delay(2)
//Hacemos click en el boton SI del popup, para corregir el dato del Libro
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//seleccionamos la celda del libro
WebUI.executeJavaScript('hot.selectCell(0,19)', null)
//Escribimos la letra del libro
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"C")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)


println("<----- ID 3 ----->") //TIENE UN BUG 221186 
//Vamos a dejar la celda del Debe y el Haber vacia y validar los campos
WebUI.executeJavaScript('hot.selectCell(1,5)', null)//Esta coordenada de la fila debe ser 1
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Ingresamos los datos del segundo asiento
WebUI.executeJavaScript('hot.setDataAtCell(2,5,"10")', null)//Aqui la fila debe ser 2
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//Se borra el dato que corresponde al Debe
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//Se borra el dato que corresponde al Haber
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,10,"PruebaTercerAsiento")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,13,"2")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,19,"C")', null)
WebUI.delay(1)
//Hacemos click el el boton terminar para que se muestre el popup indicando que hay errores en la linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Hacemos click el el boton terminar para que se muestre el popup indicando que hay errores en la linea
WebUI.verifyTextPresent('Aviso: "La fila de un asiento está incompleta y no se guardará el cambio."', false)
WebUI.delay(2)
//Hacemos click en el boton SI del popup, para corregir el dato de la celda del Debe o haber
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//seleccionamos la celda del Debe
WebUI.executeJavaScript('hot.selectCell(0,7)', null)
WebUI.delay(1)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_LEFT))
WebUI.executeJavaScript('hot.setDataAtCell(0,7,"41113")', null)
WebUI.delay(1)
//seleccionamos la celda del Haber
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.selectCell(0,6)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11211")', null)
WebUI.delay(1)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.delay(1)

//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(5)

println('<----- ID 4 ----->')
//Vamos a dejar la celda del Concepto vacia y validar los campos
WebUI.executeJavaScript('hot.selectCell(2,5)', null) //Esta coordenada de la fila debera ser 2 y se debera modificar cuando se solucione el BUG
//Agregamos una nueva linea de asiento de una sola linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Ingresamos los datos del segundo asiento
WebUI.executeJavaScript('hot.setDataAtCell(3,5,"10")', null) //Aqui la fila deberia ser 3
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,7,"41113")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//Se borra el dato que corresponde al Concepto
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,13,"2")', null)
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,19,"C")', null)
WebUI.delay(1)
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Hacemos click el el boton terminar para que se muestre el popup indicando que hay errores en la linea
WebUI.verifyTextPresent('Aviso: "La fila de un asiento está incompleta y no se guardará el cambio."', false)
WebUI.delay(2)
//Hacemos click en el boton SI del popup, para corregir el dato de la celda del Debe o haber
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//Seleccionamos la celda del Concepto
WebUI.executeJavaScript('hot.selectCell(0,10)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"PruebaCuartoAsiento")', null)
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)

//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaSegundoAsiento', false)
WebUI.delay(2)

println("<----- ID 6 ----->")
//Vamos a ingresar un codigo de moneda que no existe
WebUI.executeJavaScript('hot.selectCell(3,5)', null)//Esta coordenada de la fila debera ser 4 y se debera modificar cuando se solucione el BUG
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Ingresamos el sexto asiento de una sola linea
WebUI.executeJavaScript('hot.setDataAtCell(4,5,"16")', null)//Aqui la fila deberia ser 5
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,7,"41113")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,10,"PruebaSextoAsiento")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//Se ingresa un codigo de moneda que no exista
WebUI.executeJavaScript('hot.setDataAtCell(4,11,"9")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,13,"2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,14,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4,19,"C")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Hacemos click el el boton terminar para que se muestre el popup indicando que hay errores en la linea
WebUI.verifyTextPresent('Error: "El código de la moneda no es válido."', false)
WebUI.delay(2)
//Hacemos click en el boton SI del popup, para corregir el dato de la celda del Debe o haber
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//Seleccionamos la celda de la Moneda e ingresamos el codigo correcto
WebUI.executeJavaScript('hot.selectCell(0,11)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaSegundoAsiento', false)
WebUI.delay(2)


println('<----- ID 7 ----->')
//Vamos a ingresar un codigo de cuenta que no se permite usar
WebUI.executeJavaScript('hot.selectCell(4,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Ingresamos el sexto asiento de una sola linea
WebUI.executeJavaScript('hot.setDataAtCell(5,5,"16")', null) //Aqui la fila deberia ser 5
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,6,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.delay(1)
WebUI.verifyTextPresent('La cuenta 11 es un título. No se puede realizar imputaciones a títulos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarPopupTitulo'))
WebUI.delay(1)
//Seleccionamos nuevamente la celda para eliminarla
WebUI.executeJavaScript('hot.selectCell(5,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)

//Desde aqui vamos a crear asiento de multiples lineas
println('<----- ID 8 ----->')
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(5,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(5,5,"5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,6,"11211")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(5,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,10,"PruebaVariasLineas")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,12,"58000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(5,19,"I")', null)
WebUI.delay(1)
//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(6,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(6,5,"5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(6,6,"11211")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(6,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(6,10,"PruebaVariasLineas_1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(6,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(6,12,"2000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(6,19,"I")', null)
WebUI.delay(1)
//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(7,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(7,5,"5")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(7,7,"41113")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(7,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(7,10,"PruebaVariasLineas_2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(7,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(7,12,"50000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(7,19,"I")', null)
WebUI.delay(1)
//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(8,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(8,5,"5")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(8,7,"41211")', null)
for (i = 0; i < 2; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(8,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(8,10,"PruebaVariasLineas_3")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(8,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(8,12,"9000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for (i = 0; i < 3; i++) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(8,19,"I")', null)
WebUI.delay(1)

//Despues haber realizado el asiento con varias lineas vamos a validarlo
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Se ha detectado un asiento con error.', false)
WebUI.verifyTextPresent('Error: "El asiento no está balanceado."', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//Vamos a corregir el valos de $9.000 por $10.000 para que el asiento balancee
WebUI.executeJavaScript('hot.selectCell(3,12)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(3,12,"10000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.delay(1)
//Validamos el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(2)
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Carpetas/Asientos/Asientos - Validaciones_2'), [:], FailureHandling.STOP_ON_FAILURE)