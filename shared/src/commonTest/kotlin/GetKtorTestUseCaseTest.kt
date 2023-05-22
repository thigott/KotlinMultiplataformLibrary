import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetKtorTestUseCaseTest: KoinComponent {

    private val getKtorTestUseCase by inject<GetKtorTestUseCase>()

    @BeforeTest
    fun before() {
        startKoin {
            modules(
                listOf(
                    domainModule,
                    dataModule
                )
            )
        }
    }

    @Test
    fun `RETURN MUST NOT BE NULL AND CONTAINS HTML`() = runBlocking {
        val useCaseResult = getKtorTestUseCase.run().first()
        assertTrue(useCaseResult.isEmpty().not() and useCaseResult.contains("html"))
    }
}