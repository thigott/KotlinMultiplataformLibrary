import android.content.Context
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesDataSource
import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetUserLoggedDataUseCase
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import io.mockk.every
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
import kotlin.test.assertTrue

class GetUserLoggedDataUseCaseTest : KoinComponent {

    private val loginUseCase by inject<LoginUseCase>()
    private val getUserLoggedDataUseCase by inject<GetUserLoggedDataUseCase>()
    private val context = mockk<Context>(relaxed = true)
    private val localDataSource = mockk<SharedPreferencesDataSource>(relaxed = true)

    private var userAccessToken = ""

    @Before
    fun before() {
        startKoin {
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    module {
                        single { context }
                        single { localDataSource }
                    }
                )
            )
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `RIGHT CREDENTIALS MUST RETURN A VALID USER MODEL`() = runBlocking {
        val loginResult = loginUseCase.run(
            params = LoginUseCase.Params(
                username = "096.089.009-21",
                password = "babyyoda2"
            )
        ).first()

        userAccessToken = loginResult.accessToken

        stubLocalDataSource()

        val userLoggedDataResult = getUserLoggedDataUseCase.run().first()

        assertTrue(userLoggedDataResult.cpf.isNotEmpty())
    }

    private fun stubLocalDataSource() {
        every {
            localDataSource.getString(any())
        } returns userAccessToken
    }
}