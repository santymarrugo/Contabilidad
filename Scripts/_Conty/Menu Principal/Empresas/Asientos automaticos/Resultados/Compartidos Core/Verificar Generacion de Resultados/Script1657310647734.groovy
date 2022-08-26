import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.DecimalFormat
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
 * Fecha creacion : 8-7-2022
 * QA : Santiago Marrugo
 */

//Accedemos a la opcion de asientos para buscar el asiento generado automaticamente
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonEditarMesAsiento'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/MesAsiento03-2022'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(5)

//Verificamos la cantidad total de asiento que se deben generar
def String totalAsientos = WebUI.executeJavaScript('return hot.countRows()', null)
println(totalAsientos)
assert totalAsientos == '19'

/**
 * Verificamos que el dia de los asientos generados sea el ultimo dia del mes
 */
WebUI.executeJavaScript('hot.selectCell(8,5)', null)
def String diaLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String diaLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (diaLinea9 == '31' && diaLinea10 == '31' && diaLinea11 == '31' && diaLinea12 == '31' && diaLinea13 == '31' 
	&& diaLinea14 == '31' && diaLinea15 == '31' && diaLinea16 == '31' && diaLinea17 == '31' && diaLinea18 == '31' && diaLinea19 == '31')

//Creamos un objeto de la clase DecimalFormat para poder formatear el valor obtenido de la celda con
DecimalFormat formato2Decimales = new DecimalFormat("#.00")

/**
 * Verificamos el total de Perdidas de los asientos generados sea el ultimo dia del mes
 */
WebUI.executeJavaScript('hot.selectCell(8,12)', null)
def float totalPerdidas_f = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalPerdidas_f)

//Le aplicamos el formato a 2 decimales y lo asignamos a una variable tipo String
def String totalPerdidas_s = formato2Decimales.format(totalPerdidas_f).toString()

//Cambiamos la coma (,) por un punto (.)
totalPerdidas_s = totalPerdidas_s.replace(',', '.')
assert totalPerdidas_s == '30747.54'

/**
 * Verificamos el total de Ganancias de los asientos generados sea el ultimo dia del mes
 */
WebUI.executeJavaScript('hot.selectCell(16,12)', null)
def float totalGanancias_f = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalGanancias_f)

//Le aplicamos el formato a 2 decimales y lo asignamos a una variable tipo String
def String totalGanancias_s = formato2Decimales.format(totalGanancias_f).toString()

//Cambiamos la coma (,) por un punto (.)
totalGanancias_s = totalGanancias_s.replace(',', '.')
assert totalGanancias_s == '68924.29'

/**
 * Verificamos la cuenta del Debe y el Haber del Asiento del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(17,6)', null)
def String debeResultadoEjercicio = WebUI.executeJavaScript('return hot.getValue()', null)
println(debeResultadoEjercicio)

WebUI.executeJavaScript('hot.selectCell(18,7)', null)
def String haberResultadoEjercicio = WebUI.executeJavaScript('return hot.getValue()', null)
println(haberResultadoEjercicio)

assert debeResultadoEjercicio == '5601' && haberResultadoEjercicio == '3511'

/**
 * Verificamos el concepto y total de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(17,10)', null)
def String conceptoDebeRE = WebUI.executeJavaScript('return hot.getValue()', null)
println(conceptoDebeRE)
WebUI.executeJavaScript('hot.selectCell(18,10)', null)
def String conceptoHaberRE = WebUI.executeJavaScript('return hot.getValue()', null)
println(conceptoHaberRE)

assert conceptoDebeRE == 'Resultado del ejercicio $' && conceptoHaberRE == 'Resultado del ejercicio $'

//Totales
WebUI.executeJavaScript('hot.selectCell(17,12)', null)
def float totalAsiento1_RE = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalAsiento1_RE)

WebUI.executeJavaScript('hot.selectCell(18,12)', null)
def float totalAsiento2_RE = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalAsiento2_RE)

assert totalAsiento1_RE == 38176.75 && totalAsiento2_RE == 38176.75

/**
 * Verificamos la moneda de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,11)', null)
def String monLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String monLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (monLinea9 == '0' && monLinea10 == '0' && monLinea11 == '0' && monLinea12 == '0' && monLinea13 == '0'
	&& monLinea14 == '0' && monLinea15 == '0' && monLinea16 == '0' && monLinea17 == '0' && monLinea18 == '0' && monLinea19 == '0')

/**
 * Verificamos los impuestos de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,13)', null)
def String impLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String impLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (impLinea9 == '0' && impLinea10 == '0' && impLinea11 == '0' && impLinea12 == '0' && impLinea13 == '0'
	&& impLinea14 == '0' && impLinea15 == '0' && impLinea16 == '0' && impLinea17 == '0' && impLinea18 == '0' && impLinea19 == '0')

/**
 * Verificamos el IVA de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,14)', null)
def String IVALinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String IVALinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (IVALinea9 == '0' && IVALinea10 == '0' && IVALinea11 == '0' && IVALinea12 == '0' && IVALinea13 == '0'
	&& IVALinea14 == '0' && IVALinea15 == '0' && IVALinea16 == '0' && IVALinea17 == '0' && IVALinea18 == '0' && IVALinea19 == '0')

/**
 * Verificamos la cotizacion de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,18)', null)
def String cotLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String cotLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (cotLinea9 == '-1' && cotLinea10 == '-1' && cotLinea11 == '-1' && cotLinea12 == '-1' && cotLinea13 == '-1'
	&& cotLinea14 == '-1' && cotLinea15 == '-1' && cotLinea16 == '-1' && cotLinea17 == '-1' && cotLinea18 == '-1' && cotLinea19 == '-1')

/**
 * Verificamos el Libro de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,19)', null)
def String libLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String libLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (libLinea9 == 'U' && libLinea10 == 'U' && libLinea11 == 'U' && libLinea12 == 'U' && libLinea13 == 'U'
	&& libLinea14 == 'U' && libLinea15 == 'U' && libLinea16 == 'U' && libLinea17 == 'U' && libLinea18 == 'U' && libLinea19 == 'U')


/**
 * Verificamos el Tipo de los Asientos del Resultado del Ejercicio
 */
WebUI.executeJavaScript('hot.selectCell(8,21)', null)
def String tipoLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String tipoLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

/**
 * Esta parte tiene un bug, debido a que los valores correctos de todas las celdas es RES y algunas vienen vacias. BUG # 253480
 */
assert (tipoLinea9 == 'RES' && tipoLinea10 == '' && tipoLinea11 == '' && tipoLinea12 == '' && tipoLinea13 == ''
	&& tipoLinea14 == '' && tipoLinea15 == '' && tipoLinea16 == '' && tipoLinea17 == 'RES' && tipoLinea18 == 'RES' && tipoLinea19 == 'RES')

/**
 * Verificamos el Origen de los Asientos del Resultado del Ejercicio
 */

WebUI.executeJavaScript('hot.selectCell(8,22)', null)
def String origenLinea9 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea10 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea11 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea12 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea13 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea14 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea15 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea16 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea17 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea18 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String origenLinea19 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (origenLinea9 == 'RES' && origenLinea10 == 'RES' && origenLinea11 == 'RES' && origenLinea12 == 'RES' && origenLinea13 == 'RES'
	&& origenLinea14 == 'RES' && origenLinea15 == 'RES' && origenLinea16 == 'RES' && origenLinea17 == 'RES' && origenLinea18 == 'RES' && origenLinea19 == 'RES')
