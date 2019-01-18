package sonia.com.flohtweets.flohtweets

import sonia.com.flohtweets.model.TwitterAPIResponse

interface FlohContract {

    interface FlohView<FlohTweetsPresenter> {

        var presenter: FlohTweetsPresenter

        fun showLoader()

        fun hideLoader()

        fun populateFlohTweets()

        fun showErrorMessage(throwable: Throwable)
    }

    interface FlohTweets {

        interface OnFinishedListener {
            fun onSuccess(twitterAPIResponse: TwitterAPIResponse)
            fun onError(error: Throwable)
            fun onTerminate()
        }

        fun fetchFlohTweets(listener: FlohTweets.OnFinishedListener)
    }

    interface FlohTweetsPresenter {

        fun pullToRefresh()

        fun endlessScrolling()

        fun onDestroy()
    }
}