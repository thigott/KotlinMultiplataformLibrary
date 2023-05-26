import android.content.Context
import com.thigott.kotlinmultiplataformlibrary.data.models.core.RequestException
import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import io.mockk.MockKAnnotations
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class AndroidLoginUseCaseTest : KoinComponent {

    private val loginUseCase by inject<LoginUseCase>()
    private val context = mockk<Context>(relaxed = true)

    @Before
    fun before() {
        MockKAnnotations.init(this)

        startKoin {
            modules(
                listOf(
                    module {
                        single { context }
                    },
                    domainModule,
                    dataModule
                )
            )
        }
    }

    @After
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