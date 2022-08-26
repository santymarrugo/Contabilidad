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
import com.kms.katalon.core.util.KeywordUtil

/**
 * Fecha creacion : 20-05-2022
 * QA : Santiago Marrugo
 */

//Tipo de mayor
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDTipoDeMayor'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), '01/02/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), '28/02/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
//Importes en una moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDImportesEn'), '1', false)
WebUI.delay(1)
//Moneda en pesos
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaUno'), '1', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/BotonAceptarPopupMayores'))
WebUI.delay(5)

//Verificamos la generacion del reporte, sin validar los calculos del mismo
def String tituloReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/LabelTituloReporte Mayor A-1M-P'))
println(tituloReporte)
assert tituloReporte == 'Mayor analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/LabelPeriodoReporte Mayor A-1M-P'))
println(periodoReporte)
assert periodoReporte == '01/02/2022 a 28/02/2022. $'
//
WebUI.verifyTextPresent('Haber $', false)
WebUI.delay(1)

//Verificamos los valores del reporte
def String saldoPesosConcepto1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto1'))
println(saldoPesosConcepto1)
def String saldoPesosConcepto2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto2'))
println(saldoPesosConcepto2)
def String saldoPesosConcepto3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto3'))
println(saldoPesosConcepto3)
def String saldoPesosConcepto4 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto4'))
println(saldoPesosConcepto4)
def String saldoPesosConcepto5 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto5'))
println(saldoPesosConcepto5)
def String saldoPesosConcepto6 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/SaldoPesosConcepto6'))
println(saldoPesosConcepto6)

assert (saldoPesosConcepto1 == '-4,200.00' && saldoPesosConcepto2 == '381.82' && saldoPesosConcepto3 == '270.49' && saldoPesosConcepto4 == '-1,500.00' 
&& saldoPesosConcepto5 == '3,818.18' && saldoPesosConcepto6 == '1,229.51')

//Totales
def String totalDebitos = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/TotalDebitos'))
println(totalDebitos)
def String totalCreditos = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/TotalCreditos'))
println(totalCreditos)
def String totalSaldoDeudores = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/TotalSaldoDeudores'))
println(totalSaldoDeudores)
def String totalSaldoAcreedores = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/TotalSaldoAcreedores'))
println(totalSaldoAcreedores)
def String totalSaldoDeudoresAcreedores = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Mayor/TotalSaldoDeudoresAcreedores'))
println(totalSaldoDeudoresAcreedores)

assert totalDebitos == '9,300.00' && totalCreditos == '9,300.00' && totalSaldoDeudores == '5,700.00' && totalSaldoAcreedores == '5,700.00' && totalSaldoDeudoresAcreedores == '0.00'

