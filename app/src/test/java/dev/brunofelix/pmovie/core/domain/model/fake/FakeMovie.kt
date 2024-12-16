package dev.brunofelix.pmovie.core.domain.model.fake

sealed class FakeMovie {
    data object JohnWick : FakeMovie()
    data object Avengers : FakeMovie()
    data object AlienRomulus : FakeMovie()
}