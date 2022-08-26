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
import com.kms.katalon.core.util.KeywordUtil as KWU

/**
 * Fecha creacion : 24-08-2022
 * QA : Santiago Marrugo
 */

//Accedemos a la opcion Cierre y apertura del menu
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabEmpresa'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticosCierreApertura'))
WebUI.delay(1)
//Verificamos que estemos en la ventana de Cierre y Apertura
WebUI.verifyTextPresent('Cierre y apertura del ejercicio', false)

//Seleccionamos la fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaInicial'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaInicial'), '01/02/2022')
//Seleccionamos la fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaFinal'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputFechaFinal'), '28/02/2022')
//Seleccionamos la cuenta del resultado del ejercicio
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputCuentaResultadodelEjercicio'))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputCuentaResultadodelEjercicio'), '3511')
//Seleccionamos la cuenta de resultados acumulados
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputCuentaResultadosAcumulados'))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/InputCuentaResultadosAcumulados'), '3512')
//Seleccionamos la moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/DDMonedaDeCierre'), '1', false)
//Se corre el proceso
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/BotonAceptarPopupCierreyApertura'))
WebUI.delay(1)
//Aqui nos indica que antes debe debe generarse el proceso de resultados
WebUI.verifyTextPresent('Para generar los asientos de Cierre y Apertura deberá previamente estar generado el asiento de Resultados. ¿Desea generar el asiento de Resultados ahora?', false)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/BotonSIPopupConfirmacion'))
WebUI.delay(1)
//Se nos abre una nueva pestana y nos dirigimos a ella para poder correr el proceso de resultados
WebUI.switchToWindowIndex(1)
//Procedemos a correr el proceso de resultados
WebUI.verifyTextPresent('Resultados del ejercicio:', false)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), '01/02/2022')
//Escogemos la fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), '28/02/2022')
//Seleccionamos la cuenta de Perdidas y Ganancias
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputPerdidasYGanancias'))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputPerdidasYGanancias'), '5601')
//Seleccionamos la cuenta del Resultado del Ejercicio
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputResultadoEjercicio'))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputResultadoEjercicio'), '3511')
//Seleccionamos la moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/DDMonedaDeCierre'), '1', false)
//Se genera el Asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/BotonAceptarPopupResultados'))
WebUI.delay(1)
def String resultadoEjercicio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/MensajeResultadoEjercicioExitoso'))
println(resultadoEjercicio)
assert resultadoEjercicio == 'Se generaron correctamente los asientos de Resultado del ejercicio.'
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/BotonAceptarMensajeResultadoExitoso'))

//Regresamos a la pestana de Cierre y Apertura y hacemos un segundo intento de correr el proceso
WebUI.switchToWindowIndex(0)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/BotonNOPopupConfirmacion'))
WebUI.delay(1)
//Se corre el proceso
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/BotonAceptarPopupCierreyApertura'))
WebUI.delay(1)
WebUI.verifyTextPresent('Se generaron correctamente los asientos de Cierre y Apertura del ejercicio.', false)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/BotonAceptarPopupCierreyAperturaExitoso'))
WebUI.delay(1)
WebUI.verifyTextPresent('Cierre y apertura del ejercicio', false)
//Ingresamos al mes de asiento para verificar los valores que se generaron
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/RadioButtonMesCierreApertura'))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
