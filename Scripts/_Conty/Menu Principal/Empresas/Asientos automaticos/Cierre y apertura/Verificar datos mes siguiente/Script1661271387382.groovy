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

/**
 * Fecha creacion : 25-08-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el mes siguiente generado
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/RadioButtonMesSiguienteCierreApertura'))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Asientos 3/2022', false)

//Verificamos los valores de la columna Dia
WebUI.executeJavaScript('hot.selectCell(0, 5)', null)
def String valorDia1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 5)', null)
def String valorDia2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 5)', null)
def String valorDia3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 5)', null)
def String valorDia4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 5)', null)
def String valorDia5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 5)', null)
def String valorDia6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 5)', null)
def String valorDia7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 5)', null)
def String valorDia8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorDia1 == '1' && valorDia2 == '1' && valorDia3 == '1' && valorDia4 == '1'
	 && valorDia5 == '1' && valorDia6 == '1' && valorDia7 == '1' && valorDia8 == '1')

//Verificamos los valores de la columna Debe
WebUI.executeJavaScript('hot.selectCell(0, 6)', null)
def String valorDebe1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 6)', null)
def String valorDebe2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 6)', null)
def String valorDebe3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 6)', null)
def String valorDebe4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 6)', null)
def String valorDebe5 = WebUI.executeJavaScript('return hot.getValue()', null)

assert valorDebe1 == '1112011' && valorDebe2 == '11112' && valorDebe3 == '1112012' && valorDebe4 == '11111' && valorDebe5 == '11332'

//Verificamos los valores de la columna Haber
WebUI.executeJavaScript('hot.selectCell(5, 7)', null)
def String valorHaber1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 7)', null)
def String valorHaber2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 7)', null)
def String valorHaber3 = WebUI.executeJavaScript('return hot.getValue()', null)

assert valorHaber1 == '3512' && valorHaber2 == '21111' &&  valorHaber3 == '21333'

//Verificamos los valores de la columna Concepto
WebUI.executeJavaScript('hot.selectCell(0, 10)', null)
def String datoConcepto1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 10)', null)
def String datoConcepto2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 10)', null)
def String datoConcepto3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 10)', null)
def String datoConcepto4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 10)', null)
def String datoConcepto5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 10)', null)
def String datoConcepto6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 10)', null)
def String datoConcepto7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 10)', null)
def String datoConcepto8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (datoConcepto1 == 'Apertura del ejercicio $' && datoConcepto2 == 'Apertura del ejercicio $' && datoConcepto3 == 'Apertura del ejercicio $'
	&& datoConcepto4 == 'Apertura del ejercicio $' && datoConcepto5 == 'Apertura del ejercicio $' && datoConcepto6 == 'Apertura del ejercicio $'
	&& datoConcepto7 == 'Apertura del ejercicio $' && datoConcepto8 == 'Apertura del ejercicio $')

//Verificamos los valores de la columna Moneda
WebUI.executeJavaScript('hot.selectCell(0, 11)', null)
def String datoMoneda1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 11)', null)
def String datoMoneda2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 11)', null)
def String datoMoneda3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 11)', null)
def String datoMoneda4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 11)', null)
def String datoMoneda5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 11)', null)
def String datoMoneda6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 11)', null)
def String datoMoneda7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 11)', null)
def String datoMoneda8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (datoMoneda1 == '0' && datoMoneda2 == '0' && datoMoneda3 == '0' && datoMoneda4 == '0'
	&& datoMoneda5 == '0' && datoMoneda6 == '0' && datoMoneda7 == '0' && datoMoneda8 == '0')

//Verificamos los valores de la columna Total
WebUI.executeJavaScript('hot.selectCell(0, 12)', null)
def String valorTotal1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 12)', null)
def String valorTotal2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 12)', null)
def String valorTotal3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 12)', null)
def String valorTotal4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 12)', null)
def String valorTotal5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 12)', null)
def String valorTotal6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 12)', null)
def String valorTotal7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 12)', null)
def String valorTotal8 = WebUI.executeJavaScript('return hot.getValue()', null)

//Tomamos el valor solo con dos decimales, ya que los valores viene con muchos decimales
valorTotal5 = valorTotal5.substring(0, 7)
valorTotal6 = valorTotal6.substring(0, 8)
valorTotal8 = valorTotal8.substring(0, 7)

assert (valorTotal1 == '33000' && valorTotal2 == '20590' && valorTotal3 == '6120' && valorTotal4 == '2550'
	 && valorTotal5 == '1613.93' && valorTotal6 == '43300.16' && valorTotal7 == '18500' && valorTotal8 == '2073.77')

//Verificamos los valores de la columna Total N (impuestos)
WebUI.executeJavaScript('hot.selectCell(0, 13)', null)
def String codImpuesto1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 13)', null)
def String codImpuesto2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 13)', null)
def String codImpuesto3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 13)', null)
def String codImpuesto4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 13)', null)
def String codImpuesto5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 13)', null)
def String codImpuesto6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 13)', null)
def String codImpuesto7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 13)', null)
def String codImpuesto8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codImpuesto1 == '0' && codImpuesto2 == '0' && codImpuesto3 == '0' && codImpuesto4 == '0'
	&& codImpuesto5 == '0' && codImpuesto6 == '0' && codImpuesto7 == '0' && codImpuesto8 == '0')

//Verificamos los valores de la columna IVA
WebUI.executeJavaScript('hot.selectCell(0, 14)', null)
def String valorIVA1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 14)', null)
def String valorIVA2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 14)', null)
def String valorIVA3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 14)', null)
def String valorIVA4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 14)', null)
def String valorIVA5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 14)', null)
def String valorIVA6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 14)', null)
def String valorIVA7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 14)', null)
def String valorIVA8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorIVA1 == '0' && valorIVA2 == '0' && valorIVA3 == '0' && valorIVA4 == '0'
	 && valorIVA5 == '0' && valorIVA6 == '0' && valorIVA7 == '0' && valorIVA8 == '0')

//Verificamos los valores de la columna Cotizacion
WebUI.executeJavaScript('hot.selectCell(0, 18)', null)
def String valorCotizacion1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 18)', null)
def String valorCotizacion2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 18)', null)
def String valorCotizacion3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 18)', null)
def String valorCotizacion4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 18)', null)
def String valorCotizacion5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 18)', null)
def String valorCotizacion6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 18)', null)
def String valorCotizacion7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 18)', null)
def String valorCotizacion8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorCotizacion1 == '-1' && valorCotizacion2 == '-1' && valorCotizacion3 == '-1'
	 && valorCotizacion4 == '-1' && valorCotizacion5 == '-1' && valorCotizacion6 == '-1'
	 && valorCotizacion7 == '-1' && valorCotizacion8 == '-1')

//Verificamos los valores de la columna Libro (L)
WebUI.executeJavaScript('hot.selectCell(0, 19)', null)
def String codLibro1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 19)', null)
def String codLibro2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 19)', null)
def String codLibro3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 19)', null)
def String codLibro4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 19)', null)
def String codLibro5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 19)', null)
def String codLibro6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 19)', null)
def String codLibro7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 19)', null)
def String codLibro8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codLibro1 == 'P' && codLibro2 == 'P' && codLibro3 == 'P' && codLibro4 == 'P'
	 && codLibro5 == 'P' && codLibro6 == 'P' && codLibro7 == 'P' && codLibro8 == 'P')

//Verificamos los valores de la columna Tipo
WebUI.executeJavaScript('hot.selectCell(0, 21)', null)
def String codTipo1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 21)', null)
def String codTipo2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 21)', null)
def String codTipo3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 21)', null)
def String codTipo4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 21)', null)
def String codTipo5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 21)', null)
def String codTipo6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 21)', null)
def String codTipo7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 21)', null)
def String codTipo8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codTipo1 == 'APE' && codTipo2 == 'APE' && codTipo3 == 'APE' && codTipo4 == 'APE'
	 && codTipo5 == 'APE' && codTipo6 == 'APE' && codTipo7 == 'APE' && codTipo8 == 'APE')


//Verificamos los valores de la columna Origen
WebUI.executeJavaScript('hot.selectCell(0, 22)', null)
def String codOrigen1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(1, 22)', null)
def String codOrigen2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(2, 22)', null)
def String codOrigen3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(3, 22)', null)
def String codOrigen4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(4, 22)', null)
def String codOrigen5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(5, 22)', null)
def String codOrigen6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(6, 22)', null)
def String codOrigen7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(7, 22)', null)
def String codOrigen8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codOrigen1 == 'AP' && codOrigen2 == 'AP' && codOrigen3 == 'AP' && codOrigen4 == 'AP'
	 && codOrigen5 == 'AP' && codOrigen6 == 'AP' && codOrigen7 == 'AP' && codOrigen8 == 'AP')

WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextPresent('3/2022', false)
WebUI.verifyTextPresent('2/2022', false)

