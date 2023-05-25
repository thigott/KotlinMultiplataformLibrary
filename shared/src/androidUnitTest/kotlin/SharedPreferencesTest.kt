import android.content.Context
import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.SharedPreferencesRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.mockito.Mockito.mock
import kotlin.test.AfterTest
import kotlin.test.BeforeTest


class SharedPreferencesTest: KoinComponent {

    private val sharedPreferencesRepository by inject<SharedPreferencesRepository>()
    private val context = mock(Context::class.java)

    private val contextModule = module {
        single<Context> { context }
    }

    @BeforeTest
    fun before() {
        startKoin {
            modules(
                listOf(
                    contextModule,
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
}