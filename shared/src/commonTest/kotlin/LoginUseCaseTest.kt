import com.thigott.kotlinmultiplataformlibrary.data.models.core.RequestException
import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class LoginUseCaseTest: KoinComponent {

    private val loginUseCase by inject<LoginUseCase>()

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

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `RIGHT CREDENTIALS MUST RETURN A VALID ACCESS TOKEN`() = runBlocking {
        val loginResult = loginUseCase.run(
            params = LoginUseCase.Params(
                username = "096.089.009-21",
                password = "babyyoda2"
            )
        ).first()

        assertTrue(loginResult.accessToken.isNotEmpty())
    }

    @Test
    fun `WRONG CREDENTIALS MUST RETURN A VALID ACCESS TOKEN`() {
        assertFailsWith<RequestException> {
            runBlocking {
                loginUseCase.run(
                    params = LoginUseCase.Params(
                        username = "096.089.009-21",
                        password = "babyyoda1"
                    )
                ).first()
            }
        }
    }
}